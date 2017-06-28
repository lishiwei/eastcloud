package com.orientalfinance.eastcloud.module.javabean;

import java.io.Serializable;

/**
 * Created by lzy on 2017/6/27.
 * email:lizy@oriental-finance.com
 */

public class ControllerRequest implements Serializable {
    private String mac_addr;  //机顶盒MAC地址
    private String key;        //key用于服务端路由（为固定的几个值）
    private String content;    //遥控器按键内容

    public ControllerRequest() {
    }

    public ControllerRequest(String key, String content) {
        this.key = key;
        this.content = content;
    }

    public ControllerRequest(String mac_addr, String key, String content) {
        this.mac_addr = mac_addr;
        this.key = key;
        this.content = content;
    }

    public String getMac_addr() {
        return mac_addr;
    }

    public void setMac_addr(String mac_addr) {
        this.mac_addr = mac_addr;
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
                "mac_addr='" + mac_addr + '\'' +
                ", key='" + key + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
