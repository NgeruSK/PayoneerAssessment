package com.capsols.payoneerapp.Models;

import com.google.gson.annotations.SerializedName;
public class Links {
    @SerializedName("logo")

    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
