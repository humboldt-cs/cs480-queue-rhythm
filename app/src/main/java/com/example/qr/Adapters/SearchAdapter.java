package com.example.qr.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qr.Models.Search;
import com.example.qr.Models.Track;
import com.example.qr.R;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{
    Context context;
    Search searchItem;
    Boolean active = true;

    public SearchAdapter(Context context, Search searchItem) {
        this.context = context;
        this.searchItem = searchItem;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View searchView = LayoutInflater.from(context).inflate(R.layout.item_song, parent, false);
        return new SearchAdapter.ViewHolder(searchView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        Object song = searchItem.getItems().get(position);
        holder.bind(song);
    }

    @Override
    public int getItemCount() {
        return searchItem.getTotal();
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
            ivQAlbumCover = itemView.findViewById(R.id.ivQAlbum);
            // SpotifyService.getImageApi();
        }

        public void bind(final Object object) {
            if(object.getClass().toString() == "track") {
                Track track = (Track) object;
                tvQSongTitle.setText(track.getName());
                tvQAlbumName.setText(track.getAlbum().getName());
                tvQArtistName.setText(track.getArtists().get(0).getName());


            }
        }
    }
}
