package com.example.qr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    Context context;
    //ArrayList<Music> musicList;
    List<Song> songList;
    Boolean active = true;

    public SongAdapter(Context context, List<Song> songList) {
        this.context = context;
        this.songList = songList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View songView = LayoutInflater.from(context).inflate(R.layout.item_song, parent, false);
        return new ViewHolder(songView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.bind(song);
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvQSongTitle;
        public TextView tvQArtistName;
        public TextView tvQAlbumName;
        public ImageView ivQAlbumCover;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQSongTitle = itemView.findViewById(R.id.tvQSongTitle);
            tvQArtistName = itemView.findViewById(R.id.tvQArtistName);
            tvQAlbumName = itemView.findViewById(R.id.tvQAlbumName);
            //ivQAlbumCover = itemView.findViewById(R.id.ivQAlbumCover);
        }

        public void bind(final Song song) {
            tvQSongTitle.setText(song.getSongTitle());
            tvQArtistName.setText(song.getArtist());
            tvQAlbumName.setText(song.getAlbumName());
        }
    }
}
