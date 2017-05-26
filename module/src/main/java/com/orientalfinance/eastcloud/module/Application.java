package com.orientalfinance.eastcloud.module;

/**
 * Created by 29435 on 2017/5/26.
 */

public class Application {
    String url;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Application{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Application(String url, String name) {
        this.url = url;
        this.name = name;
    }
}
