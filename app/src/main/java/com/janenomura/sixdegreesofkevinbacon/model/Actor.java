package com.janenomura.sixdegreesofkevinbacon.model;

import android.graphics.Bitmap;

public class Actor {

    private int actorID;
    private String actorName;
    private String characterName;
    private String actorPosterPath;
    private Bitmap actorImage;


    public int getActorID() {
        return actorID;
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }


    public String getActorPosterPath() {
        return actorPosterPath;
    }

    public void setActorPosterPath(String actorPosterPath) {
        this.actorPosterPath = actorPosterPath;
    }

    public Bitmap getActorImage() {
        return actorImage;
    }

    public void setActorImage(Bitmap actorImage) {
        this.actorImage = actorImage;
    }

}
