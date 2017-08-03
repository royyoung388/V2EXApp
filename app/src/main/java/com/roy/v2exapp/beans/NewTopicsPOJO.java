package com.roy.v2exapp.beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by roy on 17-8-1.
 */

public class NewTopicsPOJO implements POJO{
    private int id;
    private String title;
    private String url;
    private String content;
    @SerializedName("content_rendered")
    private String contentRendered;
    private int replies;
    private MemberPOJO member;
    private NodePOJO node;
    private long created;
    @SerializedName("last_modified")
    private long lastModified;
    @SerializedName("last_touched")
    private long lastTouched;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }

    public String getContentRendered() {
        return contentRendered;
    }

    public int getReplies() {
        return replies;
    }

    public MemberPOJO getMemberPOJO() {
        return member;
    }

    public NodePOJO getNodePOJO() {
        return node;
    }

    public long getCreated() {
        return created;
    }

    public long getLastModified() {
        return lastModified;
    }

    public long getLastTouched() {
        return lastTouched;
    }
}
