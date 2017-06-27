package com.orientalfinance.eastcloud.module.javabean;

import java.io.Serializable;

/**
 * Created by lzy on 2017/6/27.
 * email:lizy@oriental-finance.com
 */

public class ControllerRequest implements Serializable {
    private String key;
    private String content;

    public ControllerRequest() {
    }

    public ControllerRequest(String key, String content) {
        this.key = key;
        this.content = content;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ControllerRequest{" +
                "key='" + key + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
