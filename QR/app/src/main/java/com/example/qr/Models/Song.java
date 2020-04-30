package com.example.qr.Models;

public class Song {
    public static String albumCover;
    public static String songTitle;
    public static String artistName;
    public static String albumName;
    public static String trackString;

    private String id;
    private String name;

    public Song(String albumCover,String songTitle,String artistName,String albumName){
        setAlbumCover(albumCover);
        setSongTitle(songTitle);
        setArtist(artistName);
        setAlbumName(albumName);
        setTrack(trackString);
    }


    public String getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(String cover) {
        this.albumCover = cover;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String title) {
        this.songTitle = title;
    }

    public String getArtist() { return artistName; }

    public void setArtist(String artist) {
        this.artistName = artist;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String name) {
        this.albumName = name; }

    public String getTrack() { return trackString; }

    public void setTrack(String track) { this.trackString = track; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
