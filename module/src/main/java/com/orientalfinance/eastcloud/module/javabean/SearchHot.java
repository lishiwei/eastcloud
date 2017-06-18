package com.orientalfinance.eastcloud.module.javabean;

/**
 * Created by 29435 on 2017/6/18.
 */

public class SearchHot {
    String hotword;

    public String getHotword() {
        return hotword;
    }

    public void setHotword(String hotword) {
        this.hotword = hotword;
    }

    public SearchHot(String hotword) {

        this.hotword = hotword;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "hotword='" + hotword + '\'' +
                '}';
    }
}
