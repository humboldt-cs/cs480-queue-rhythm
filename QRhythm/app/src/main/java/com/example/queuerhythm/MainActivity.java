package com.example.queuerhythm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Music> musicList;
    Button btnPlay;
    MediaPlayer mediaPlayer;
    Context context;
    Boolean active = false;
    ArrayAdapter arrayAdapter;
    PlayerAdapter adapter;
    RecyclerView rvMusic;
    Music music;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getIds();
        RecyclerView rvMusic = findViewById(R.id.rvMusic);


        musicList = new ArrayList<>();

        musicList.add(new Music("Valerian Root", "MF Doom", R.raw.valerianroot));
        musicList.add(new Music("Agrimony", "MF Doom", R.raw.agrimony));
        musicList.add(new Music("Pennyroyal", "MF Doom", R.raw.pennyroyal));
        musicList.add(new Music("Arabic Gum", "MF Doom", R.raw.arabicgum));
        musicList.add(new Music("Lavender Buds", "MF Doom", R.raw.lavenderbuds));
        musicList.add(new Music("Benzoin Gum", "MF Doom", R.raw.benzoingum));
        musicList.add(new Music("White Willow Bark", "MF Doom", R.raw.whitewillowbark));
        musicList.add(new Music("Bergamot Wild", "MF Doom", R.raw.bergamotwild));
        musicList.add(new Music("Orange Blossoms", "MF Doom", R.raw.orangeblossoms));
        musicList.add(new Music("Calamus Root", "MF Doom", R.raw.calamusroot));
        musicList.add(new Music("Coffin Nails", "MF Doom", R.raw.coffinnails));
        musicList.add(new Music("Dragon's Blood Resin", "MF Doom", R.raw.dragonsbloodresin));
        musicList.add(new Music("Kava Kava Root", "MF Doom", R.raw.kavakavaroot));
        musicList.add(new Music("Elder Blossoms", "MF Doom", R.raw.elderblossoms));
        musicList.add(new Music("Jasmine Blossoms", "MF Doom", R.raw.jasmineblossom));
        musicList.add(new Music("Styrax Gum", "MF Doom", R.raw.styraxgum));
        musicList.add(new Music("Black Snake Root", "MF Doom", R.raw.blacksnakeroot));
        musicList.add(new Music("Blood Root", "MF Doom", R.raw.bloodroot));
        musicList.add(new Music("Horehound", "MF Doom", R.raw.horehound));
        musicList.add(new Music("Star Anis", "MF Doom", R.raw.staranis));
        musicList.add(new Music("Dragon's Blood", "MF Doom", R.raw.dragonsblood));
        musicList.add(new Music("Lemon Grass", "MF Doom", R.raw.lemongrass));
        musicList.add(new Music("Four Thieves Vinegar", "MF Doom", R.raw.fourthievesvinegar));

        // create the adapter
        MusicAdapter musicAdapter = new MusicAdapter(this, (ArrayList<Music>) musicList);
        // Set adapter on the RV
        rvMusic.setAdapter(musicAdapter);
        //Set layout manager on RV
        rvMusic.setLayoutManager(new LinearLayoutManager(this));




    }
    public void getIds(){
        rvMusic = findViewById(R.id.rvMusic);
        btnPlay=findViewById(R.id.btnPlay);
        //sb = findViewById(R.id.progress);
    }

}
