package com.example.qr;

import androidx.recyclerview.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.SeekBar;
import android.view.View;

import androidx.annotation.NonNull;
import android.view.MenuItem;

import android.content.Intent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.os.Bundle;
import com.spotify.protocol.types.PlayerState;
import com.spotify.android.appremote.api.SpotifyAppRemote;
import com.spotify.android.appremote.api.PlayerApi;

import android.widget.Toast;
import com.example.qr.Models.Track;

import android.content.Context;

public class QueueActivity extends MainActivity {
    Context context = QueueActivity.this;
    ImageView ivAlbum;
    ImageView ivPlay;
    ImageView ivPause;
    TextView tvNameAlbum;
    TextView tvNameArtist;
    TextView tvSongName;
    SeekBar skSeeking;
    RecyclerView rvMusic;
    BottomNavigationView btmNav;
    PlayerState playerState;

    protected PlayerApi mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        mPlayer = SpotifyService.mSpotifyAppRemote.getPlayerApi();

        btmNav = findViewById(R.id.bottomNav);

        btmNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.searchIcon:
                        Intent intent = new Intent(QueueActivity.this,SearchActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.homeIcon:
                        Intent intenttwo = new Intent(QueueActivity.this,MainActivity.class);
                        startActivity(intenttwo);
                        return true;
                    case R.id.playIcon:
                        /* Intent intentthree = new Intent(QueueActivity.this,QueueActivity.class);
                        startActivity(intentthree); */
                        return true;
                    default: return true;
                }
            }
        });

        ivAlbum = findViewById(R.id.ivAlbum);
        ivPlay = findViewById(R.id.ivPlay);
        ivPlay.setBackgroundResource(R.drawable.icon_play);
        ivPause = findViewById(R.id.ivPause);
        tvNameAlbum = findViewById(R.id.tvNameAlbum);
        tvNameArtist = findViewById(R.id.tvNameArtist);
        tvSongName = findViewById(R.id.tvSongName);
        skSeeking = findViewById(R.id.sbSeeking);
        rvMusic = findViewById(R.id.rvMusic);

        String currSong = mPlayer.getPlayerState().toString();
        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasbeenclickedPlay == false & hasbeenclickedPause == true) {
                    mPlayer.resume();
                    ivPlay.setBackgroundResource(R.drawable.icon_play);
                    hasbeenclickedPause = false;
                    hasbeenclickedPlay = true;
                } else if (hasbeenclickedPlay == true & hasbeenclickedPause == false) {
                    ivPlay.setBackgroundResource(R.drawable.icon_pause);
                    mPlayer.pause();
                    hasbeenclickedPause = true;
                    hasbeenclickedPlay = false;
                } else {
                    mPlayer.play("spotify:playlist:7KisalzWjJZC8GVSFgZBhF");
                    hasbeenclickedPlay = true;
                    // Toast.makeText(context, currTrack.getSongTitle(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        ivPause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                hasbeenclickedPlay = true;
                hasbeenclickedPause = false;
                ivPlay.setBackgroundResource(R.drawable.icon_play);
                mPlayer.skipNext();
            }
        });
    }
}
