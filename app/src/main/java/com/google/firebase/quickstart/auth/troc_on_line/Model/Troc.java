package com.google.firebase.quickstart.auth.troc_on_line.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Collection;

public class Troc implements Serializable {

    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("image_url")
    private String imageURL;

    @SerializedName("date")
    private String date;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
