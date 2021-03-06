package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by lzy on 2017/6/12.
 * email:lizy@oriental-finance.com
 */

public class Address implements Serializable{

    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    @SerializedName("uname")
    private String userName;
    @SerializedName("phone")
    private String userPhone;
    @SerializedName("addr")
    private String address;
    @SerializedName("zonename")
    private String zone;

    private String street;

    @SerializedName("isdefault")
    private int isDefault;

    public Address() {
    }

    public Address(String userName, String userPhone, String address, String zone, int isDefault) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.address = address;
        this.zone = zone;
        this.isDefault = isDefault;
    }

    public Address(String id, String userName, String userPhone, String address, String zone, int isDefault) {
        this.userName = userName;
        this.id = id;
        this.userPhone = userPhone;
        this.address = address;
        this.zone = zone;
        this.isDefault = isDefault;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int isDefault() {
        return isDefault;
    }

    public void setDefault(int aDefault) {
        isDefault = aDefault;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                "userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", address='" + address + '\'' +
                ", zone='" + zone + '\'' +
                ", street='" + street + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }


    public static class AddRequestParam {

        String uname;
        String phone;
        String zonecode;
        String zonename;
        String addr;
        String isdefault;

        public AddRequestParam(String uname, String phone, String zonecode, String zonename, String addr, String isdefault) {
            this.uname = uname;
            this.phone = phone;
            this.zonecode = zonecode;
            this.zonename = zonename;
            this.addr = addr;
            this.isdefault = isdefault;
        }

        public String getPhone() {
            return phone;
        }

        @Override
        public String toString() {
            return "AddRequestParam{" +
                    "uname='" + uname + '\'' +
                    ", phone='" + phone + '\'' +
                    ", zonecode='" + zonecode + '\'' +
                    ", zonename='" + zonename + '\'' +
                    ", addr='" + addr + '\'' +
                    ", isdefault='" + isdefault + '\'' +
                    '}';
        }
    }

    public static class EditRequestParam {
        String id;
        String uname;
        String phone;
        String zonecode;
        String zonename;
        String addr;
        String isdefault;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getZonecode() {
            return zonecode;
        }

        public void setZonecode(String zonecode) {
            this.zonecode = zonecode;
        }

        public String getZonename() {
            return zonename;
        }

        public void setZonename(String zonename) {
            this.zonename = zonename;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public String getIsdefault() {
            return isdefault;
        }

        public void setIsdefault(String isdefault) {
            this.isdefault = isdefault;
        }

        public EditRequestParam(String id, String uname, String phone, String zonecode, String zonename, String addr, String isdefault) {
            this.uname = uname;
            this.id = id;
            this.phone = phone;
            this.zonecode = zonecode;
            this.zonename = zonename;
            this.addr = addr;
            this.isdefault = isdefault;
        }

        @Override
        public String toString() {
            return "AddRequestParam{" +
                    "id='" + id + '\'' +
                    "uname='" + uname + '\'' +
                    ", phone='" + phone + '\'' +
                    ", zonecode='" + zonecode + '\'' +
                    ", zonename='" + zonename + '\'' +
                    ", addr='" + addr + '\'' +
                    ", isdefault='" + isdefault + '\'' +
                    '}';
        }
    }
}
