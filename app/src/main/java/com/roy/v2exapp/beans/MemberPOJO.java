package com.roy.v2exapp.beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by roy on 17-8-1.
 */

public class MemberPOJO implements POJO{
    private int id;
    private String username;
    private String tagline;
    @SerializedName("avatar_mini")
    private String avatarMini;
    @SerializedName("avatar_normal")
    private String avatarNormal;
    @SerializedName("avatar_large")
    private String avatarLarge;

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
