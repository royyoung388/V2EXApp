package com.roy.v2exapp.beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by roy on 17-8-1.
 */

public class MemberPOJO implements POJO {
    private int id;
    private String status;
    private String url;
    private String username;
    private String website;
    private String twitter;
    private String psn;
    private String github;
    private String btc;
    private String location;
    private String bio;
    private String tagline;
    @SerializedName("avatar_mini")
    private String avatarMini;
    @SerializedName("avatar_normal")
    private String avatarNormal;
    @SerializedName("avatar_large")
    private String avatarLarge;
    private long created;

    public String getStatus() {
        return status;
    }

    public String getUrl() {
        return url;
    }

    public String getWebsite() {
        return website;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getPsn() {
        return psn;
    }

    public String getGithub() {
        return github;
    }

    public String getBtc() {
        return btc;
    }

    public String getLocation() {
        return location;
    }

    public String getBio() {
        return bio;
    }

    public long getCreated() {
        return created;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getTagline() {
        return tagline;
    }

    public String getAvatarMini() {
        return "http:" + avatarMini;
    }

    public String getAvatarNormal() {
        return "http:" + avatarNormal;
    }

    public String getAvatarLarge() {
        return "http:" + avatarLarge;
    }
}
