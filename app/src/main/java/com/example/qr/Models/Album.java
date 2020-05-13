package com.example.qr.Models;

import com.spotify.protocol.types.Image;

import java.util.ArrayList;

public class Album {
    private String albumType;
    private ArrayList<Artist> artists;
    private String href;
    private String id;
    private ArrayList<Image> images;
    private String name;
    private String type;
    private String uri;

    public String getAlbumType() {
        return albumType;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public String getHref() {
        return href;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }
}
