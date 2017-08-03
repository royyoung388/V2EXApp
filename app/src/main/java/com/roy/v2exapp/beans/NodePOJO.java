package com.roy.v2exapp.beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by roy on 17-8-1.
 */

public class NodePOJO implements POJO{
    private int id;
    private String name;
    private String title;
    @SerializedName("title_alternative")
    private String titleAlternative;
    private String url;
    private String topics;
    @SerializedName("avatar_mini")
    private String avatarMini;
    @SerializedName("avatar_normal")
    private String avatarNormal;
    @SerializedName("avatar_large")
    private String avatarLarge;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleAlternative() {
        return titleAlternative;
    }

    public String getUrl() {
        return url;
    }

    public String getTopics() {
        return topics;
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
