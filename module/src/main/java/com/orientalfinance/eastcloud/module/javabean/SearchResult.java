package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;
import com.orientalfinance.eastcloud.module.Retrofit.ShowRequestParam;

/**
 * Created by 29435 on 2017/6/18.
 */

public class SearchResult {
    @SerializedName("program_id")
    String programId;
    @SerializedName("show_img")
    String url;
    String name;
    @SerializedName("intro")
    String introduce;
    @SerializedName("channel_id")
    String channelId;
    @SerializedName("channel_name")
    String channelName;
    @SerializedName("air_time")
    String playTime;

    public SearchResult(String programId, String url, String name, String introduce, String channelId, String channelName, String playTime) {
        this.programId = programId;
        this.url = url;
        this.name = name;
        this.introduce = introduce;
        this.channelId = channelId;
        this.channelName = channelName;
        this.playTime = playTime;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "SearchResult{" +
                "programId='" + programId + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", channelId='" + channelId + '\'' +
                ", channelName='" + channelName + '\'' +
                ", playTime='" + playTime + '\'' +
                '}';
    }

    public static class SearchRequestParam extends ShowRequestParam {
        String hotword;

        public SearchRequestParam(int start, int length, String hotword) {
            super(start, length);
            this.hotword = hotword;
        }

        public SearchRequestParam(String start, String length, String hotword) {
            super(start, length);
            this.hotword = hotword;
        }

        public String getHotword() {
            return hotword;
        }

        public void setHotword(String hotword) {
            this.hotword = hotword;
        }

        @Override
        public String toString() {
            return "SearchRequestParam{" +
                    "hotword='" + hotword + '\'' +
                    '}';
        }
    }
}
