package com.orientalfinance.eastcloud.module.javabean;

/**
 * Created by 29435 on 2017/6/30.
 */

public class CheckVersionResult {
String updateFlag;
String downloadUrl;

    public CheckVersionResult(String updateFlag, String downloadUrl) {
        this.updateFlag = updateFlag;
        this.downloadUrl = downloadUrl;
    }

    public String getUpdateFlag() {
        return updateFlag;
    }

    public void setUpdateFlag(String updateFlag) {
        this.updateFlag = updateFlag;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Override
    public String toString() {
        return "CheckVersionResult{" +
                "updateFlag='" + updateFlag + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                '}';
    }
}
