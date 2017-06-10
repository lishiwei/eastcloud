package com.orientalfinance.eastcloud.module.javabean;

/**
 * Created by 29435 on 2017/6/10.
 */

public class TV {
    String Own ;
    String property;
    String status;

    public TV(String own, String property, String status) {
        Own = own;
        this.property = property;
        this.status = status;
    }

    public String getOwn() {
        return Own;
    }

    public void setOwn(String own) {
        Own = own;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
