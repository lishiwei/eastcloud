package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 29435 on 2017/6/18.
 */

public class Advertisement {
    @SerializedName("banner_id")
    String bannerId;
    @SerializedName("bimage")
    String bannerImage;
    @SerializedName("channel_id")
    String channelId;

    public Advertisement(String bannerId, String bannerImage, String channelId) {
        this.bannerId = bannerId;
        this.bannerImage = bannerImage;
        this.channelId = channelId;
    }

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "bannerId='" + bannerId + '\'' +
                ", bannerImage='" + bannerImage + '\'' +
                ", channelId='" + channelId + '\'' +
                '}';
    }
}
