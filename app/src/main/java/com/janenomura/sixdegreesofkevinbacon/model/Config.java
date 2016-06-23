package com.janenomura.sixdegreesofkevinbacon.model;

import java.util.List;

public class Config {

    private String baseImageURL;
    private List<String> posterSize;
    private List<String> profileSize;
    private List<String> changeKeys;

    public String getBaseImageURL() {
        return baseImageURL;
    }

    public void setBaseImageURL(String baseImageURL) {
        this.baseImageURL = baseImageURL;
    }

    public List<String> getPosterSize() {
        return posterSize;
    }

    public void setPosterSize(List<String> posterSize) {
        this.posterSize = posterSize;
    }

    public List<String> getProfileSize() {
        return profileSize;
    }

    public void setProfileSize(List<String> profileSize) {
        this.profileSize = profileSize;
    }

    public List<String> getChangeKeys() {
        return changeKeys;
    }

    public void setChangeKeys(List<String> changeKeys) {
        this.changeKeys = changeKeys;
    }


}
