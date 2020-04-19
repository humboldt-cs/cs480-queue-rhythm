package com.example.qr;

import androidx.recyclerview.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.SeekBar;

import android.os.Bundle;

public class QueueActivity extends MainActivity {
    ImageView ivAlbum;
    ImageView ivPlay;
    ImageView ivPause;
    TextView tvNameAlbum;
    TextView tvNameArtist;
    TextView tvSongName;
    SeekBar skSeeking;
    RecyclerView rvMusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        ivAlbum = findViewById(R.id.ivAlbum);
        ivPlay = findViewById(R.id.ivPlay);
        ivPause = findViewById(R.id.ivPause);
        tvNameAlbum = findViewById(R.id.tvNameAlbum);
        tvNameArtist = findViewById(R.id.tvNameArtist);
        tvSongName = findViewById(R.id.tvSongName);
        skSeeking = findViewById(R.id.sbSeeking);
        rvMusic = findViewById(R.id.rvMusic);


    }

}
