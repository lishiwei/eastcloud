package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 29435 on 2017/6/18.
 */

public class Advertisement {
    @SerializedName("bulletin_id")
    String adverId;
    @SerializedName("bulletin_name")
    String adverName;

    public String getAdverId() {
        return adverId;
    }

    public void setAdverId(String adverId) {
        this.adverId = adverId;
    }

    public String getAdverName() {
        return adverName;
    }

    public void setAdverName(String adverName) {
        this.adverName = adverName;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "adverId='" + adverId + '\'' +
                ", adverName='" + adverName + '\'' +
                '}';
    }
}
