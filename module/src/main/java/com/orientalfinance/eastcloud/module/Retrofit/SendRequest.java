package com.orientalfinance.eastcloud.module.Retrofit;

/**
 * Created by lzy on 2017/6/10.
 * email:lizy@oriental-finance.com
 */

public class SendRequest {
    private String s;
    private String sign;

    public SendRequest() {
    }

    public SendRequest(String s, String sign) {
        this.s = s;
        this.sign = sign;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "SendRequest{" +
                "s='" + s + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
