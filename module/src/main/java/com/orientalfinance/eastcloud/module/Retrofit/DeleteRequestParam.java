package com.orientalfinance.eastcloud.module.Retrofit;

/**
 * Created by 29435 on 2017/6/14.
 */

public class DeleteRequestParam {
    String id;

    public DeleteRequestParam(String id) {
        this.id = id;
    }

    public DeleteRequestParam() {
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "DeleteRequestParam{" +
                "id='" + id + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }
}
