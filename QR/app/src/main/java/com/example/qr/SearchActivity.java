package com.example.qr;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.view.View;
import android.content.Intent;


public class SearchActivity extends MainActivity{
    EditText etSongSearch;
    Spinner spinnerSearchType;
    RecyclerView rvSearchedSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etSongSearch = findViewById(R.id.etSongSearch);
        spinnerSearchType = findViewById(R.id.spinnerSearchType);
        // setting up the drop-down menu
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.searchType,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSearchType.setAdapter(adapter);
        rvSearchedSongs = findViewById(R.id.rvSearchedSongs);



    }
}
