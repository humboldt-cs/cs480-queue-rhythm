package com.example.qr.Models;

import com.google.gson.annotations.SerializedName;
import com.spotify.protocol.types.Image;

import java.util.ArrayList;

public class User {
    @SerializedName("display_name")
    private String displayName;
    private String id;
    private String href;
    private ArrayList<Image> images;
    private String type;
    private String uri;

    public String getDisplayName() {
        return displayName;
    }

    public String getId() {
        return id;
    }

    public String getHref() {
        return href;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }
}
