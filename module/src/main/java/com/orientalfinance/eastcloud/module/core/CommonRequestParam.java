package com.orientalfinance.eastcloud.module.core;

/**
 * Created by 29435 on 2017/6/8.
 */

public class CommonRequestParam implements RequestParam {
    String s;
    String sn;

    public void setS(String s) {
        this.s = s;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getS() {
        return s;
    }

    public String getSn() {
        return sn;
    }

    public CommonRequestParam(String s, String sn) {
        this.s = s;
        this.sn = sn;
    }
}
