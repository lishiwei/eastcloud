package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 29435 on 2017/6/10.
 */

public class TV {
    @SerializedName("box_id")
    String id;

    @SerializedName("box_location")
    String location;

    @SerializedName("box_username")
    String userName;

    @SerializedName("box_address")
    String registAddress;

    @SerializedName("box_mac")
    String macAddress;


    @SerializedName("box_Status")
    String status;

    String property;

    public TV(String id, String location, String userName, String registAddress, String macAddress, String status, String property) {
        this.id = id;
        this.location = location;
        this.userName = userName;
        this.registAddress = registAddress;
        this.macAddress = macAddress;
        this.status = status;
        this.property = property;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegistAddress() {
        return registAddress;
    }

    public void setRegistAddress(String registAddress) {
        this.registAddress = registAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public TV(String userName, String property, String status) {
        this.userName = userName;
        this.property = property;
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String own) {
        userName = own;
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

    @Override
    public String toString() {
        return "TV{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", userName='" + userName + '\'' +
                ", registAddress='" + registAddress + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", status='" + status + '\'' +
                ", property='" + property + '\'' +
                '}';
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public static class DelTVRequestParam {
        public DelTVRequestParam(String box_id) {
            this.box_id = box_id;
        }

        String box_id;

        public String getBox_id() {
            return box_id;
        }
    }

    public static class ScanTVRequestParam {
        String box_mac;

        public ScanTVRequestParam(String box_mac) {
            this.box_mac = box_mac;
        }
    }
}
