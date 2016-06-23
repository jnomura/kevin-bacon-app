package com.janenomura.sixdegreesofkevinbacon.model;

import android.graphics.Bitmap;

public class Media {

    private int mediaID;
    private String mediaTitle;
    private String releaseDate;
    private String mediaType;
    private String mediaPosterPath;
    private Bitmap mediaImage;


    public int getMediaID() {
        return mediaID;
    }

    public void setMediaID(int movieID) {
        this.mediaID = movieID;
    }

    public String getMediaTitle() {
        return mediaTitle;
    }

    public void setMediaTitle(String mediaTitle) {
        this.mediaTitle = mediaTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaPosterPath() {
        return mediaPosterPath;
    }

    public void setMediaPosterPath(String mediaPosterPath) {
        this.mediaPosterPath = mediaPosterPath;
    }

    public Bitmap getMediaImage() {
        return mediaImage;
    }

    public void setMediaImage(Bitmap mediaImage) {
        this.mediaImage = mediaImage;
    }


}
