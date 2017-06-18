package com.orientalfinance.eastcloud.module.Retrofit;

/**
 * Created by 29435 on 2017/6/14.
 */

public class ShowRequestParam {
    String start;
    String length;

    public ShowRequestParam(int start, int length) {
        this.start = String.valueOf(start);
        this.length = String.valueOf(length);
    }

    public ShowRequestParam(String start, String length) {
        this.start = start;
        this.length = length;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "ShowRequestParam{" +
                "start=" + start +
                ", length=" + length +
                '}';
    }
}
