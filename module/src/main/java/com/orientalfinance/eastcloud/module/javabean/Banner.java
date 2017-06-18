package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 29435 on 2017/6/18.
 */

public class Banner {
    @SerializedName("banner_id")
    String bannerId;
    @SerializedName("bimage")

    String bannerImage;

    public Banner(String bannerId, String bannerImage) {
        this.bannerId = bannerId;
        this.bannerImage = bannerImage;
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

    @Override
    public String toString() {
        return "Banner{" +
                "bannerId='" + bannerId + '\'' +
                ", bannerImage='" + bannerImage + '\'' +
                '}';
    }
}
