package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 29435 on 2017/5/26.
 */

public class Movie {
    @SerializedName("show_img")
    String imageUrl;
    @SerializedName("name")
    String title;

    String tag;
    int progress;

    String programId;
    @SerializedName("intro")
    String introduce;
    @SerializedName("channel_id")
    String channelId;

    public Movie(String imageUrl, String title, String tag, int progress, String programId, String introduce, String channelId) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.tag = tag;
        this.progress = progress;
        this.programId = programId;
        this.introduce = introduce;
        this.channelId = channelId;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Movie(String imageUrl, String title, String tag) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.tag = tag;
    }

    public Movie(String imageUrl, String title, String tag, int progress) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.tag = tag;
        this.progress = progress;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", tag='" + tag + '\'' +
                ", progress=" + progress +
                ", programId='" + programId + '\'' +
                ", introduce='" + introduce + '\'' +
                ", channelId='" + channelId + '\'' +
                '}';
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
