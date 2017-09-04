package com.orientalfinance.eastcloud.module.javabean;

/**
 * Created by 29435 on 2017/6/30.
 */

public class AvatarUrl {
    String sign_url;

    public String getSign_url() {
        return sign_url;
    }

    public void setSign_url(String sign_url) {
        this.sign_url = sign_url;
    }

    public AvatarUrl(String sign_url) {

        this.sign_url = sign_url;
    }

    @Override
    public String toString() {
        return "AvatarUrl{" +
                "sign_url='" + sign_url + '\'' +
                '}';
    }
}
