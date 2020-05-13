package com.example.qr.Models;

import java.util.ArrayList;

public class Track {
    private Album album;
    private ArrayList<Artist> artists;
    private int duration_ms;
    private Boolean explicit;
    private String id;
    private String name;
    private int popularity;
    private String preview_url;
    private String type;
    private String uri;

    public Album getAlbum() {
        return album;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public int getDuration_ms() {
        return duration_ms;
    }

    public Boolean getExplicit() {
        return explicit;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getPreview_url() {
        return preview_url;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }
}
