package com.orientalfinance.eastcloud.module.javabean;

/**
 * Created by lzy on 2017/6/20.
 * email:lizy@oriental-finance.com
 */

public class TVConnectState {
    private boolean isConnection;
    private String location;

    public TVConnectState(boolean isConnection, String location) {
        this.isConnection = isConnection;
        this.location = location;
    }

    public boolean isConnection() {
        return isConnection;
    }

    public void setConnection(boolean connection) {
        isConnection = connection;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "TVConnectState{" +
                "isConnection=" + isConnection +
                ", location='" + location + '\'' +
                '}';
    }
}
