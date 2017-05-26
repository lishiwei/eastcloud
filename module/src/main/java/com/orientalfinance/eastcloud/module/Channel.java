package com.orientalfinance.eastcloud.module;

/**
 * Created by 29435 on 2017/5/26.
 */

public class Channel {
    String currentProgramBg;
    String channelName;
    String currentProgram;
    String channelLogo;
    String programTime;

    @Override
    public String toString() {
        return "Channel{" +
                "currentProgramBg='" + currentProgramBg + '\'' +
                ", channelName='" + channelName + '\'' +
                ", currentProgram='" + currentProgram + '\'' +
                ", channelLogo='" + channelLogo + '\'' +
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
