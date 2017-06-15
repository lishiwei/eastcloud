package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 29435 on 2017/5/26.
 */

public class Channel {
    String channelLogo;
    @SerializedName("program_id")
    String programId;

    String id ;

    public Channel(String channelLogo, String programId, String id, String currentProgramBg, String channelName, String currentProgram, String programTime) {
        this.channelLogo = channelLogo;
        this.programId = programId;
        this.id = id;
        this.currentProgramBg = currentProgramBg;
        this.channelName = channelName;
        this.currentProgram = currentProgram;
        this.programTime = programTime;
    }

    public String getProgramId() {

        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("play_imgs")
    String currentProgramBg;

    @SerializedName("channel_name")
    String channelName;
    @SerializedName("program_name")
    String currentProgram;

    @SerializedName("ctime")
    String programTime;

    @Override
    public String toString() {
        return "Channel{" +
                "channelLogo='" + channelLogo + '\'' +
                ", programId='" + programId + '\'' +
                ", id='" + id + '\'' +
                ", currentProgramBg='" + currentProgramBg + '\'' +
                ", channelName='" + channelName + '\'' +
                ", currentProgram='" + currentProgram + '\'' +
                ", programTime='" + programTime + '\'' +
                '}';
    }

    public Channel(String currentProgramBg, String channelName, String currentProgram, String channelLogo, String programTime) {
        this.currentProgramBg = currentProgramBg;
        this.channelName = channelName;
        this.currentProgram = currentProgram;
        this.channelLogo = channelLogo;
        this.programTime = programTime;
    }
    public Channel(String currentProgramBg, String channelName, String currentProgram, String programTime) {
        this.currentProgramBg = currentProgramBg;
        this.channelName = channelName;
        this.currentProgram = currentProgram;
        this.programTime = programTime;
    }
    public String getCurrentProgramBg() {
        return currentProgramBg;
    }

    public void setCurrentProgramBg(String currentProgramBg) {
        this.currentProgramBg = currentProgramBg;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getCurrentProgram() {
        return currentProgram;
    }

    public void setCurrentProgram(String currentProgram) {
        this.currentProgram = currentProgram;
    }

    public String getChannelLogo() {
        return channelLogo;
    }

    public void setChannelLogo(String channelLogo) {
        this.channelLogo = channelLogo;
    }

    public String getProgramTime() {
        return programTime;
    }

    public void setProgramTime(String programTime) {
        this.programTime = programTime;
    }
}
