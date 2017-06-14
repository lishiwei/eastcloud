package com.orientalfinance.eastcloud.module.Retrofit;

/**
 * Created by 29435 on 2017/6/14.
 */

public class ShowRequestParam {
    int start;
    int length;

    public ShowRequestParam(int start, int length) {
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
