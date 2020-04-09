package com.example.queuerhythm;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class PlayerAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Music> musicList;
    private MediaPlayer mediaPlayer;
    private Boolean active = true;

    public PlayerAdapter(Context context, ArrayList<Music> musicList, int layout) {
        this.context = context;
        this.musicList = musicList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        Button btnPlay;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(layout, null);

            //viewHolder.btnPlay = (ImageView) convertView.findViewById(R.id.btnPlay);
            viewHolder.btnPlay =  convertView.findViewById(R.id.btnPlay);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        final Music music = musicList.get(position);

        //play
        viewHolder.btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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



        return convertView;
    }
}
