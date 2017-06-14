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

    public void setStatus(String status) {
        this.status = status;
    }
    public static class ShowTVRequestParam{
        int start;
        int length;

        public ShowTVRequestParam(int start, int length) {
            this.start = start;
            this.length = length;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        @Override
        public String toString() {
            return "ShowTVRequestParam{" +
                    "start=" + start +
                    ", length=" + length +
                    '}';
        }
    }
}
