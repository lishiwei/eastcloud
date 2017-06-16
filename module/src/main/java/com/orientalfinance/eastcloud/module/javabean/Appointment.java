package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 29435 on 2017/6/16.
 */

public class Appointment {
    @SerializedName("channel_name")
    String channelName;

    @SerializedName("play_imgs")

    String programImgs;
    @SerializedName("program_name")

    String programName;
    @SerializedName("program_id")

    String programId;
    @SerializedName("intro")

    String programIntroduce;
    @SerializedName("ctime")

    String createTime;
    @SerializedName("p_start_time")

    String startTime;

    String id;

    boolean isChecked;

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public Appointment(String channelName, String programImgs, String programName, String programId, String programIntroduce, String createTime, String startTime, String id) {
        this.channelName = channelName;
        this.programImgs = programImgs;
        this.programName = programName;
        this.programId = programId;
        this.programIntroduce = programIntroduce;
        this.createTime = createTime;
        this.startTime = startTime;
        this.id = id;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getProgramImgs() {
        return programImgs;
    }

    public void setProgramImgs(String programImgs) {
        this.programImgs = programImgs;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgramIntroduce() {
        return programIntroduce;
    }

    public void setProgramIntroduce(String programIntroduce) {
        this.programIntroduce = programIntroduce;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "channelName='" + channelName + '\'' +
                ", programImgs='" + programImgs + '\'' +
                ", programName='" + programName + '\'' +
                ", programId='" + programId + '\'' +
                ", programIntroduce='" + programIntroduce + '\'' +
                ", createTime='" + createTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
