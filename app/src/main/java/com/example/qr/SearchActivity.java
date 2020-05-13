package com.example.qr;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qr.Adapters.SearchAdapter;
import com.example.qr.Models.Search;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchActivity extends MainActivity{
    EditText etSongSearch;
    Spinner spinnerSearchType;
    RecyclerView rvSearchedSongs;
    Button btnSearch;

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
        btnSearch = findViewById(R.id.btnSearch);

        rvSearchedSongs = findViewById(R.id.rvSearchedSongs);

        // navigation bar
        btmNav = findViewById(R.id.bottomNav);

        btmNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.searchIcon:
                        /*  Intent intent = new Intent(SearchActivity.this,SearchActivity.class);
                        startActivity(intent); */
                        return true;
                    case R.id.homeIcon:
                        Intent intenttwo = new Intent(SearchActivity.this,MainActivity.class);
                        startActivity(intenttwo);
                        return true;
                    case R.id.playIcon:
                        Intent intentthree = new Intent(SearchActivity.this,QueueActivity.class);
                        startActivity(intentthree);
                        return true;
                    default: return true;
                }
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Map<String,String> parameters = new HashMap<>();
                parameters.put("q",etSongSearch.getText().toString());
                parameters.put("type",spinnerSearchType.getSelectedItem().toString().toLowerCase());
                parameters.put("market","US");

                Call<Search> call = SpotifyService.placeHolderApi.searchItem(parameters);

                call.enqueue((new Callback<Search>() {
                    @Override
                    public void onResponse(Call<Search> call, Response<Search> response) {
                        if(!response.isSuccessful()) {
                            Toast.makeText(SearchActivity.this,"Search not successful", Toast.LENGTH_LONG);
                        }

                        Search search = response.body();

                        SearchAdapter searchAdapter = new SearchAdapter(SearchActivity.this, search);
                        rvSearchedSongs.setAdapter(searchAdapter);
                        rvSearchedSongs.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
                    }

                    @Override
                    public void onFailure(Call<Search> call, Throwable t) {
                        Log.d("Error",t.getMessage());
                    }
                }));
            }
        });

    }
    //protected void searchRequest
}
