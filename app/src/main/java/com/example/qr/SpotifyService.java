package com.example.qr;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.PlayerApi;
import com.spotify.android.appremote.api.SpotifyAppRemote;
import com.spotify.protocol.types.PlayerState;
import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SpotifyService extends MainActivity {

    public String url = "https://api.spotify.com/v1/";
    protected static PlaceHolderApi placeHolderApi;

    Context context = SpotifyService.this;
    CharSequence text = "Hello toast!";
    int duration = Toast.LENGTH_SHORT;

    protected static SpotifyAppRemote mSpotifyAppRemote;
    protected PlayerApi playerApi;
    protected PlayerState playerState;
    TextView tvMoment;
    ImageView ivIcon;

    private static final String CLIENT_ID = "c51c441a5bf749a4bf9a1a9b7987173a";
    private static final String REDIRECT_URI = "http://qr.example.com";
    private static final int REQUEST_CODE = 1337;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        tvMoment = findViewById(R.id.tvMoment);
        ivIcon = findViewById(R.id.queueIcon);

        authenticateSpotify();

    }

    @Override
    protected void onStart() {
        super.onStart();
        SpotifyAppRemote.disconnect(mSpotifyAppRemote);
        ConnectionParams connectionParams = new ConnectionParams.Builder(CLIENT_ID)
                .setRedirectUri(REDIRECT_URI)
                .showAuthView(true)
                .build();

        SpotifyAppRemote.connect(this, connectionParams,
                new Connector.ConnectionListener() {
                    @Override
                    public void onConnected(SpotifyAppRemote spotifyAppRemote) {
                        mSpotifyAppRemote = spotifyAppRemote;
                        Log.d("MainActivity", "Connected! Yay!");

                        // Now you can start interacting with App Remote
                        connected();
                    }
                    @Override
                    public void onFailure(Throwable throwable) {
                        Log.e("MainActivity", throwable.getMessage(), throwable);
                        errorHandling();
                        // Something went wrong when attempting to connect! Handle errors here

                    }
                });
    }

    private void authenticateSpotify() {
        AuthenticationRequest.Builder builder =
                new AuthenticationRequest.Builder(CLIENT_ID, AuthenticationResponse.Type.TOKEN, REDIRECT_URI);
        builder.setScopes(new String[]{"app-remote-control","playlist-modify-public","user-read-currently-playing","user-modify-playback-state"});
        AuthenticationRequest request = builder.build();
        AuthenticationClient.openLoginActivity(this, REQUEST_CODE, request);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        // Check if result comes from the correct activity
        if (requestCode == REQUEST_CODE) {
            AuthenticationResponse response = AuthenticationClient.getResponse(resultCode, intent);
            switch (response.getType()) {
                // Response was successful and contains auth token
                case TOKEN:
                    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                    OkHttpClient okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(new Interceptor() {
                                @NotNull
                                @Override
                                public okhttp3.Response intercept(@NotNull Chain chain) throws IOException {
                                    Request originalRequest = chain.request();

                                    Request newRequest = originalRequest.newBuilder()
                                            .header("Authorization","Bearer " + response.getAccessToken().toString())
                                            .build();

                                    return chain.proceed(newRequest);
                                }
                            })
                            .addInterceptor(loggingInterceptor)
                            .build();

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(okHttpClient)
                            .build();

                    placeHolderApi = retrofit.create(PlaceHolderApi.class);

                    startMainActivity();
                    // Handle successful response
                    break;

                // Auth flow returned an error
                case ERROR:
                    Log.d("ERROR",response.getError().toString());
                    // Handle error response
                    break;

                // Most likely auth flow was cancelled
                default:
                    errorHandling();
                    authenticateSpotify();
                    startMainActivity();
                    // Handle other cases
            }
        }
    }

    private void connected() {

    }

    @Override
    protected void onStop() {
        super.onStop();
        //SpotifyAppRemote.disconnect(mSpotifyAppRemote);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SpotifyAppRemote.disconnect(SpotifyService.mSpotifyAppRemote);
    }

    private void startMainActivity() {
        Intent newintent = new Intent(this, MainActivity.class);
        startActivity(newintent);
    }

    private void errorHandling(){
        PackageManager pm = getPackageManager();
        boolean isSpotifyInstalled;
        try {
            pm.getPackageInfo("com.spotify.music", 0);
            isSpotifyInstalled = true;
        } catch (PackageManager.NameNotFoundException e) {
            isSpotifyInstalled = false;
            Toast.makeText(context, "Download and Login to Spotify App to Continue!", duration).show();
            final String appPackageName = "com.spotify.music";
            final String referrer = "adjust_campaign=PACKAGE_NAME&adjust_tracker=ndjczk&utm_source=adjust_preinstall";
            try {
                Uri uri = Uri.parse("market://details")
                        .buildUpon()
                        .appendQueryParameter("id", appPackageName)
                        .appendQueryParameter("referrer", referrer)
                        .build();
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
            } catch (android.content.ActivityNotFoundException ignored) {
                Uri uri = Uri.parse("https://play.google.com/store/apps/details")
                        .buildUpon()
                        .appendQueryParameter("id", appPackageName)
                        .appendQueryParameter("referrer", referrer)
                        .build();
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
            }
        }
    }
}

