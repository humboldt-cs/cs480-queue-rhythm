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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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
                        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.homeIcon:
                        //stay home
                        return true;
                    case R.id.playIcon:
                        Intent intenttwo = new Intent(MainActivity.this, QueueActivity.class);
                        startActivity(intenttwo);
                        return true;
                    default:
                        return true;
                }
            }
        });
        songList = new ArrayList<>();


        songList.add(new Song("Album Cover", "Song title", "Artist", "Album"));
        songList.add(new Song("Album Cover", "Song title", "Artist", "Album"));
        songList.add(new Song("Album Cover", "Song title", "Artist", "Album"));
        songList.add(new Song("Album Cover", "Song title", "Artist", "Album"));
        songList.add(new Song("Album Cover", "Song title", "Artist", "Album"));
        songList.add(new Song("Album Cover", "Song title", "Artist", "Album"));

        SongAdapter songAdapter = new SongAdapter(this, (ArrayList<Song>) songList);

        rvSongs.setAdapter(songAdapter);
        rvSongs.setLayoutManager(new LinearLayoutManager(this));

        rvUsers.setAdapter(songAdapter);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));

    }
    @Override
    protected void onStop(){
        super.onStop();
    }
}

