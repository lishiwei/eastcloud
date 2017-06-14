package com.orientalfinance.eastcloud.module.javabean;

/**
 * Created by 29435 on 2017/6/13.
 */

public class Result<T> {
    T data;

    public Result(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                '}';
    }

    public void setData(T data) {
        this.data = data;
    }
}
