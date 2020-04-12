package com.example.qr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.SeekBar;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Song> songList;
    List<Song> userList;
    ImageView albumCover;
    TextView songTitle;
    TextView artistName;
    TextView albumName;
    TextView welcomeMessage;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        albumCover = findViewById(R.id.ivQAlbum);
        songTitle = findViewById(R.id.tvQSongTitle);
        artistName = findViewById(R.id.tvArtist);
        albumName = findViewById(R.id.tvQAlbumName);
        welcomeMessage = findViewById(R.id.tvWelcome);
        seekBar = findViewById(R.id.sbSeek);
        RecyclerView rvSongs = findViewById(R.id.rvQueue);
        RecyclerView rvUsers = findViewById(R.id.rvUsers);

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
}
