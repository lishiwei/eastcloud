package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 29435 on 2017/6/18.
 */

/*
节目
* result 结果信息 （list）
channel_code 频道编码
channel_name 频道名称
program_list 频道列表:
3.1 program_id 节目id
3.2 program_name 节目名称
3.3 ﻿air_time 播出时间
* */
public class Program {
    @SerializedName("program_id")
    String channelId;
    @SerializedName("program_name")
    String channelName;
    @SerializedName("air_time")
    String playTime;

    public Program(String channelId, String channelName, String playTime) {
        this.channelId = channelId;
        this.channelName = channelName;
        this.playTime = playTime;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    @Override
    public String toString() {
        return "Program{" +
                "channelId='" + channelId + '\'' +
                ", channelName='" + channelName + '\'' +
                ", playTime='" + playTime + '\'' +
                '}';
    }
}
