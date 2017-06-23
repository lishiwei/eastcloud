package com.orientalfinance.eastcloud.module.javabean;

import java.io.Serializable;

/**
 * Created by 29435 on 2017/6/8.
 */

public class User implements Serializable {
    private static final long serialVersionUID = -6091530420906090649L;

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
    private String pwd;
    private String payPwd;

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

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
                ", pwd='" + pwd + '\'' +
                '}';
    }
    public  static  class UserLoginRequestParam{
        String phone;

        @Override
        public String toString() {
            return "UserLoginRequestParam{" +
                    "phone='" + phone + '\'' +
                    ", pwd='" + pwd + '\'' +
                    '}';
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public UserLoginRequestParam(String phone, String pwd) {

            this.phone = phone;
            this.pwd = pwd;
        }

        String pwd;
    }
    public static class SendCodeRequestParam{
      public   String phone;

        public SendCodeRequestParam(String phone) {
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "VerificateCode{" +
                    "phone='" + phone + '\'' +
                    '}';
        }
    }
    public static class VerificateCodeRequestParam extends SendCodeRequestParam{
        String code;
        String msgId;
        public VerificateCodeRequestParam(String phone, String code, String msgId
        ) {
            super(phone);
            this.code = code;
            this.msgId = msgId;
        }

        @Override
        public String toString() {
            return "VerificateCodeRequestParam{" +
                    "code='" + code + '\'' +
                    "phone='" + phone + '\'' +
                    "msgId='" + msgId + '\'' +
                    '}';
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsgId() {
            return msgId;
        }

        public void setMsgId(String msgId) {
            this.msgId = msgId;
        }
    }
    public static class RegistRequestParam extends SendCodeRequestParam{
        String pwd ;

        public RegistRequestParam(String phone, String pwd) {
            super(phone);
            this.pwd = pwd;
        }

        @Override
        public String toString() {
            return "RegistRequestParam{" +
                    "pwd='" + pwd + '\'' +
                    "phone='" + phone + '\'' +
                    '}';
        }
    }

}
