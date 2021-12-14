package com.capsols.payoneerapp.Models;

import com.google.gson.annotations.SerializedName;
public class Applicable {
    @SerializedName("code")
    private String name;

    @SerializedName("label")
    private String desc;

    private Links links;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
