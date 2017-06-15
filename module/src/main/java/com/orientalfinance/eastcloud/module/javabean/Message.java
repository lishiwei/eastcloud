package com.orientalfinance.eastcloud.module.javabean;

/**
 * Created by 29435 on 2017/6/15.
 */

public class Message {
    String msgId;

    public Message(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msgId='" + msgId + '\'' +
                '}';
    }
}
