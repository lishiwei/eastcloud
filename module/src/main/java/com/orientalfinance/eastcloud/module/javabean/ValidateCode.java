package com.orientalfinance.eastcloud.module.javabean;

/**
 * Created by lzy on 2017/6/13.
 * email:lizy@oriental-finance.com
 */

public class ValidateCode {
    private String phone;
    private String code;

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

    @Override
    public String toString() {
        return "ValidateCode{" +
                "phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
