package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class Application {
        String appType;
        List<Application> appList ;
    @SerializedName("url")
    String url;
    @SerializedName("intro")
    String name;
    @SerializedName("icon")
    String icon;

    @SerializedName("app_id")
    String appId;

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public List<Application> getAppList() {
        return appList;
    }

    public void setAppList(List<Application> appList) {
        this.appList = appList;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "Application{" +
                "appType='" + appType + '\'' +
                ", appList=" + appList +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", appId='" + appId + '\'' +
                '}';
    }
    public static class Indicator{
        String appType;

        public String getAppType() {
            return appType;
        }

        public void setAppType(String appType) {
            this.appType = appType;
        }

        @Override
        public String toString() {
            return "Indicator{" +
                    "appType='" + appType + '\'' +
                    '}';
        }
    }
}
