package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 29435 on 2017/6/18.
 */
/*
channel_id 频道ID
program_url 当前播放节目图片url
program_id 当前节目id
channel_img 频道图标
air_time 当前节目播放开始时间
program_name 节目名称
 */
public class HomePageChannel {
    @SerializedName("channel_id")
    String channelid;
    @SerializedName("program_url")

    String programUrl;
    @SerializedName("program_id")

    String programId;
    @SerializedName("channel_img")

    String channelImg;
    @SerializedName("air_time")

    String startTime;
    @SerializedName("program_name")

    String programName;

    public HomePageChannel(String channelid, String programUrl, String programId, String channelImg, String startTime, String programName) {
        this.channelid = channelid;
        this.programUrl = programUrl;
        this.programId = programId;
        this.channelImg = channelImg;
        this.startTime = startTime;
        this.programName = programName;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public String getProgramUrl() {
        return programUrl;
    }

    public void setProgramUrl(String programUrl) {
        this.programUrl = programUrl;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getChannelImg() {
        return channelImg;
    }

    public void setChannelImg(String channelImg) {
        this.channelImg = channelImg;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @Override
    public String toString() {
        return "HomePageChannel{" +
                "channelid='" + channelid + '\'' +
                ", programUrl='" + programUrl + '\'' +
                ", programId='" + programId + '\'' +
                ", channelImg='" + channelImg + '\'' +
                ", startTime='" + startTime + '\'' +
                ", programName='" + programName + '\'' +
                '}';
    }

    public class Category {
        @SerializedName("cate_id")
        String cateId;
        @SerializedName("cate_name")
        String cateName;
        List<Category> child;

        public List<Category> getChild() {
            return child;
        }

        public void setChild(List<Category> child) {
            this.child = child;
        }

        public String getCateId() {
            return cateId;
        }

        public void setCateId(String cateId) {
            this.cateId = cateId;
        }

        public String getCateName() {
            return cateName;
        }

        public void setCateName(String cateName) {
            this.cateName = cateName;
        }

        public Category(String cateId, String cateName) {
            this.cateId = cateId;
            this.cateName = cateName;
        }

        @Override
        public String toString() {
            return "Catalog{" +
                    "cateId='" + cateId + '\'' +
                    ", cateName='" + cateName + '\'' +
                    '}';
        }
    }

    public static class ShowChannelRequestParam {
        public ShowChannelRequestParam(String cate_id) {
            this.cate_id = cate_id;
        }

        @Override
        public String toString() {
            return "ShowChannelRequestParam{" +
                    "cate_id='" + cate_id + '\'' +
                    '}';
        }

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        @SerializedName("catelog_id")
        String cate_id;
    }
}
