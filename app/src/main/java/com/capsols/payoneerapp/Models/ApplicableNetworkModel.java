package com.capsols.payoneerapp.Models;

import com.google.gson.annotations.SerializedName;
public class ApplicableNetworkModel {
    @SerializedName("code")
    private String name;

    @SerializedName("label")
    private String desc;

    private LinksModel linksModel;

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

    public LinksModel getLinks() {
        return linksModel;
    }

    public void setLinks(LinksModel linksModel) {
        this.linksModel = linksModel;
    }
}
