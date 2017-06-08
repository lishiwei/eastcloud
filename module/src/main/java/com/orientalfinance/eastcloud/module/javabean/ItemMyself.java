package com.orientalfinance.eastcloud.module.javabean;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ItemMyself {
    Integer drawableSrc;
    String name;

    public ItemMyself(Integer drawableSrc, String name) {
        this.drawableSrc = drawableSrc;
        this.name = name;
    }

    public Integer getDrawableSrc() {
        return drawableSrc;
    }

    public void setDrawableSrc(Integer drawableSrc) {
        this.drawableSrc = drawableSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
