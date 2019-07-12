package com.example.androidapp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {
    public Movie(String name, String description, String image, String nameEng, String premiere) {
        this.image = image;
        this.name = name;
        this.nameEng = nameEng;
        this.premiere = premiere;
        this.description = description;
    }

    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_eng")
    @Expose
    private String nameEng;
    @SerializedName("premiere")
    @Expose
    private String premiere;
    @SerializedName("description")
    @Expose
    private String description;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public String getPremiere() {
        return premiere;
    }

    public void setPremiere(String premiere) {
        this.premiere = premiere;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}