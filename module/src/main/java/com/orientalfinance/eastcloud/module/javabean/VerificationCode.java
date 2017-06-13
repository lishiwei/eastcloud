package com.orientalfinance.eastcloud.module.javabean;

import java.io.Serializable;

/**
 * Created by lzy on 2017/6/12.
 * email:lizy@oriental-finance.com
 */

public class VerificationCode implements Serializable {
    String phone;
    String code;

    public VerificationCode(String phone, String code) {
        this.phone = phone;
        this.code = code;
    }

    @Override
    public String toString() {
        return "VerificationCode{" +
                "phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
