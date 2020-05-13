package com.example.qr.Models;


public class Artist {
    private String id;
    private String name;
    private String type;
    private String uri;
    private int popularity;
    private String[] genres;
    private String href;

    public String getId() {
        return id;
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

    public int getPopularity() {
        return popularity;
    }

    public String[] getGenres() {
        return genres;
    }

    public String getHref() {
        return href;
    }
}
