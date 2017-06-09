package com.orientalfinance.eastcloud.update;

/**
 * Created by lzy on 2017/6/9.
 * email:lizy@oriental-finance.com
 */

public class AppUpdateInfo {
    public String info;
    public String downloadUrl;
    public String saveName;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }
}
