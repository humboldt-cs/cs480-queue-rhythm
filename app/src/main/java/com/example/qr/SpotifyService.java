package com.example.qr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.TextView;
import android.widget.ImageView;

import com.example.qr.Models.Song;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;
import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import android.view.MenuItem;

import android.content.Intent;
import android.content.Context;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import android.content.pm.PackageManager;
import android.net.Uri;

import android.widget.Toast;
import com.example.qr.Adapters.TrackAdapter;

public class SpotifyService extends MainActivity {

    Context context = SpotifyService.this;
    CharSequence text = "Hello toast!";
    int duration = Toast.LENGTH_SHORT;

    protected static SpotifyAppRemote mSpotifyAppRemote;
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
                    errorHandling();
                    authenticateSpotify();
                    startMainActivity();
                    // Handle successful response
                    break;

                // Auth flow returned an error
                case ERROR:
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

