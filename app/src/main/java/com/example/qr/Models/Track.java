package com.example.qr.Models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.spotify.android.appremote.api.SpotifyAppRemote;
import com.spotify.protocol.types.ImageUri;

public class Track {
    @SerializedName(value="artist")
    public final Artist artist;

    @SerializedName(value="artists")
    public final java.util.List<Artist> artists;

    @SerializedName(value="album")
    public final Album album;

    @SerializedName(value="duration_ms")
    public final long duration;

    @SerializedName(value="name")
    public final String name;

    @SerializedName(value="uri")
    public final java.lang.String uri;

    @SerializedName(value="image_id")
    public final ImageUri imageUri;

    @SerializedName(value="is_episode")
    public final boolean isEpisode;

    @SerializedName(value="is_podcast")
    public final boolean isPodcast;

    Track(Artist artist, List<Artist> artists, Album album, long duration,
         String name, String uri, ImageUri imageUri, boolean isEpisode, boolean isPodcast){
        this.artist = artist;
        this.artists = artists;
        this.album = album;
        this.duration = duration;
        this.name = name;
        this.uri = uri;
        this.imageUri = imageUri;
        this.isEpisode = isEpisode;
        this.isPodcast = isPodcast;
    }

    public Artist getArtist() {
        return this.artist;
    }

    public Album getAlbum() {
        return this.album;
    }

    public String getSongTitle() {
        return this.name;
    }
}
