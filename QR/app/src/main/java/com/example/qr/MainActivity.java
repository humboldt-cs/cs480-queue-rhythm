package com.example.qr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.TextView;
import android.widget.SeekBar;

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

import android.os.Bundle;
import android.widget.Button;
import android.view.View;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Song> songList;
    List<Song> userList;
    TextView queueName;
    TextView songTitle;
    TextView artistName;
    TextView albumName;
    TextView welcomeMessage;
    SeekBar seekBar;
    BottomNavigationView btmNav;

    private static final String CLIENT_ID = "c51c441a5bf749a4bf9a1a9b7987173a";
    private static final String REDIRECT_URI = "http://qr.example.com";
    protected SpotifyAppRemote mSpotifyAppRemote;
    private static final int REQUEST_CODE = 1337;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AuthenticationRequest.Builder builder =
                new AuthenticationRequest.Builder(CLIENT_ID, AuthenticationResponse.Type.TOKEN, REDIRECT_URI);
        builder.setScopes(new String[]{"app-remote-control","playlist-modify-public","user-read-currently-playing","user-modify-playback-state"});
        AuthenticationRequest request = builder.build();

        AuthenticationClient.openLoginActivity(this, REQUEST_CODE, request);

        queueName = findViewById(R.id.tvQueueName);
        songTitle = findViewById(R.id.tvQSongTitle);
        artistName = findViewById(R.id.tvArtist);
        albumName = findViewById(R.id.tvQAlbumName);
        welcomeMessage = findViewById(R.id.tvWelcome);
        seekBar = findViewById(R.id.sbSeek);
        RecyclerView rvSongs = findViewById(R.id.rvQueue);
        RecyclerView rvUsers = findViewById(R.id.rvUsers);
        btmNav = findViewById(R.id.bottomNav);

        btmNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.searchIcon:
                        Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.homeIcon:
                        //stay home
                        return true;
                    case R.id.playIcon:
                        Intent intenttwo = new Intent(MainActivity.this,QueueActivity.class);
                        startActivity(intenttwo);
                        return true;
                    default: return true;
                }
            }
        });
        songList = new ArrayList<>();


        songList.add(new Song("Album Cover","Song title", "Artist", "Album"));
        songList.add(new Song("Album Cover","Song title", "Artist", "Album"));
        songList.add(new Song("Album Cover","Song title", "Artist", "Album"));
        songList.add(new Song("Album Cover","Song title", "Artist", "Album"));
        songList.add(new Song("Album Cover","Song title", "Artist", "Album"));
        songList.add(new Song("Album Cover","Song title", "Artist", "Album"));

        SongAdapter songAdapter = new SongAdapter(this, (ArrayList<Song>) songList);

        rvSongs.setAdapter(songAdapter);
        rvSongs.setLayoutManager(new LinearLayoutManager(this));

        rvUsers.setAdapter(songAdapter);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));



    }
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        // Check if result comes from the correct activity
        if (requestCode == REQUEST_CODE) {
            AuthenticationResponse response = AuthenticationClient.getResponse(resultCode, intent);

            switch (response.getType()) {
                // Response was successful and contains auth token
                case TOKEN:
                    // Handle successful response
                    break;

                // Auth flow returned an error
                case ERROR:
                    // Handle error response
                    break;

                // Most likely auth flow was cancelled
                default:
                    // Handle other cases
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();


        SpotifyAppRemote.disconnect(mSpotifyAppRemote);

        ConnectionParams connectionParams =
                new ConnectionParams.Builder(CLIENT_ID)
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

                        // Something went wrong when attempting to connect! Handle errors here
                    }
                });
    }

    private void connected() {

    }

    @Override
    protected void onStop() {
        super.onStop();
        SpotifyAppRemote.disconnect(mSpotifyAppRemote);
    }
}

