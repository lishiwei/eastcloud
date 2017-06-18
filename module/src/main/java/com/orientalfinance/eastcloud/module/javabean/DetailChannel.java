package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 29435 on 2017/6/18.
 */

public class DetailChannel {
    @SerializedName("channel_code")
    String channelCode;
    @SerializedName("channel_name")
    String channelName;
    @SerializedName("program_list")
    List<Program> programList;

    public DetailChannel(String channelCode, String channelName, List<Program> programList) {
        this.channelCode = channelCode;
        this.channelName = channelName;
        this.programList = programList;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public List<Program> getProgramList() {
        return programList;
    }

    public void setProgramList(List<Program> programList) {
        this.programList = programList;
    }

    @Override
    public String toString() {
        return "DetailChannel{" +
                "channelCode='" + channelCode + '\'' +
                ", channelName='" + channelName + '\'' +
                ", programList=" + programList +
                '}';
    }
    public static class ShowRequestParam{
       @SerializedName("channel_id")
        String channelId;

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        @Override
        public String toString() {
            return "ShowRequestParam{" +
                    "channelId='" + channelId + '\'' +
                    '}';
        }
    }
}
