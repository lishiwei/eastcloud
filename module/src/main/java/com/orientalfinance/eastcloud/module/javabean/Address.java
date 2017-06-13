package com.orientalfinance.eastcloud.module.javabean;

import java.io.Serializable;

/**
 * Created by lzy on 2017/6/12.
 * email:lizy@oriental-finance.com
 */

public class Address implements Serializable {
    private String userName;
    private String userPhone;
    private String address;
    private String zone;
    private boolean isDefault;

    public Address() {
    }

    public Address(String userName, String userPhone, String address, String zone, boolean isDefault) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.address = address;
        this.zone = zone;
        this.isDefault = isDefault;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public String toString() {
        return "Address{" +
                "userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", address='" + address + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }
}
