package com.example.queuerhythm;

public class Music {
    private String title;
    private String artist;
    private int track;


    public Music(String title, String artist, int track) {
        this.title = title;
        this.artist = artist;
        this.track = track;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }
}
