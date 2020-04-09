package com.example.queuerhythm;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {

    Context context;
    List<Music> musicList;
    MediaPlayer mediaPlayer;
    Boolean active = true;
    //int layout;

    public MusicAdapter(Context context, ArrayList<Music> arrayList) {
        this.context = context;
        this.musicList = arrayList;
      //  this.layout = layout;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View musicView = LayoutInflater.from(context).inflate(R.layout.music_item, parent,false);
        return new ViewHolder(musicView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Music music = musicList.get(position);
        holder.bind(music);
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        TextView tvArtist;
        //Button btnPlay;
       // ImageView ivCover;
       // ImageView ivPlay;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvArtist = itemView.findViewById(R.id.tvArtist);
            //ivCover = itemView.findViewById(R.id.ivCover);
             //btnPlay = itemView.findViewById(R.id.btnPlay);


        }

        public void bind(final Music music) {
            tvTitle.setText(music.getTitle());
            tvArtist.setText(music.getArtist());

            //Glide.with(context).load(music.getCoverPath().into(ivCover));
            //ivCover.setIm

            // When artist name is pressed
            tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Create Toast for testing
                    Toast.makeText(context, music.getTitle(),Toast.LENGTH_SHORT).show();

                    // Play
                    if(active){
                        mediaPlayer = MediaPlayer.create(context, music.getTrack());
                        active = false;
                    }
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.pause();
                        // viewHolder.ivPlay.setImageResource(R.drawable.ic_play);
                    }else {
                        mediaPlayer.start();
                        //viewHolder.ivPlay.setImageResource(R.drawable.ic_pause);
                    }
                }
            });

            tvArtist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Create Toast for testing
                    Toast.makeText(context, music.getArtist(),Toast.LENGTH_SHORT).show();

                    // Play
                    if(active){
                        mediaPlayer = MediaPlayer.create(context, music.getTrack());
                        active = false;
                    }
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.pause();
                        // viewHolder.ivPlay.setImageResource(R.drawable.ic_play);
                    }else {
                        mediaPlayer.start();
                        //viewHolder.ivPlay.setImageResource(R.drawable.ic_pause);
                    }
                }
            });



        }

    }

}
