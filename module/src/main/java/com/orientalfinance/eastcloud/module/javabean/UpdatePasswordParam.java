package com.orientalfinance.eastcloud.module.javabean;

/**
 * Created by lzy on 2017/6/13.
 * email:lizy@oriental-finance.com
 */

public class UpdatePasswordParam {
    private String phone;
    private String password;

    public UpdatePasswordParam() {
    }

    public UpdatePasswordParam(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UpdatePasswordParam{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
