package com.orientalfinance.eastcloud.module.javabean;

/**
 * Created by 29435 on 2017/6/30.
 */

public class CheckVersionRequestParam {
    String version;
    String os_type;

    public CheckVersionRequestParam(String version, String os_type) {
        this.version = version;
        this.os_type = os_type;
    }

    @Override
    public String toString() {
        return "CheckVersionRequestParam{" +
                "version='" + version + '\'' +
                ", os_type='" + os_type + '\'' +
                '}';
    }
}
