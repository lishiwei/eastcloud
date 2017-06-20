package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 29435 on 2017/6/18.
 */

public class HorizontalProgram {
    @SerializedName("program_id")
    String programId;
    @SerializedName("show_img")
    String imageUrl;
    @SerializedName("name")
    String programeName;
    @SerializedName("intro")
    String programeIntroduce;
    @SerializedName("channel_id")
    String channelId;

    public HorizontalProgram() {
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProgrameName() {
        return programeName;
    }

    public void setProgrameName(String programeName) {
        this.programeName = programeName;
    }

    public String getProgrameIntroduce() {
        return programeIntroduce;
    }

    public void setProgrameIntroduce(String programeIntroduce) {
        this.programeIntroduce = programeIntroduce;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public HorizontalProgram(String programId, String imageUrl, String programeName, String programeIntroduce, String channelId) {
        this.programId = programId;
        this.imageUrl = imageUrl;
        this.programeName = programeName;
        this.programeIntroduce = programeIntroduce;
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "CurrentHit{" +
                "programId='" + programId + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", programeName='" + programeName + '\'' +
                ", programeIntroduce='" + programeIntroduce + '\'' +
                ", channelId='" + channelId + '\'' +
                '}';
    }
}
