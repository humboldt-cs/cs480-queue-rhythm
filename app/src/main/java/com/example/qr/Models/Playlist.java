package com.example.qr.Models;

import com.google.gson.annotations.SerializedName;
import com.spotify.protocol.types.Image;

import java.util.ArrayList;

public class Playlist {
    private Boolean collaborative;
    private String href;
    private String id;
    private ArrayList<Image> images;
    private String name;
    private User owner;

    @SerializedName("public")
    private Boolean isPublic;
    private String type;
    private String uri;

    public Boolean getCollaborative() {
        return collaborative;
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

    public User getOwner() {
        return owner;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }
}
