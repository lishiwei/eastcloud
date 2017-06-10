package com.orientalfinance.eastcloud.module.javabean;

/**
 * Created by 29435 on 2017/6/8.
 */

public class User {
    /**
     * 1. phone 手机号
     * 2. name 真实姓名
     * 3. nick_name 呢称
     * 4. id_card 身份证
     * 5. msg_push 推送状态
     * 6. sign_url 文件HTTP地址
     * 7. token 用户认证信息
     */
    private String name;
    private String phone;
    private String nick_name;
    private String id_card;
    private boolean msg_push;
    private String sign_url;
    private String token;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public boolean isMsg_push() {
        return msg_push;
    }

    public void setMsg_push(boolean msg_push) {
        this.msg_push = msg_push;
    }

    public String getSign_url() {
        return sign_url;
    }

    public void setSign_url(String sign_url) {
        this.sign_url = sign_url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", id_card='" + id_card + '\'' +
                ", msg_push=" + msg_push +
                ", sign_url='" + sign_url + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
