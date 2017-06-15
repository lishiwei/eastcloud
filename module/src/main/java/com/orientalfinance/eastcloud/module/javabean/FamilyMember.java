package com.orientalfinance.eastcloud.module.javabean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 29435 on 2017/6/10.
 */

public class FamilyMember {

    @SerializedName("sign_url")
    String userAvatar;

    String relation;
    String name;
    String id;
    String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public FamilyMember(String userAvatar, String relation) {
        this.userAvatar = userAvatar;
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "userAvatar='" + userAvatar + '\'' +
                ", relation='" + relation + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class EditFamilyRequestParam extends AddFamilyRequestParam {
        public String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public EditFamilyRequestParam(String name, String relation, String phone, String file, String id) {
            super(name, relation, phone, file);
            this.id = id;
        }

        @Override
        public String toString() {
            return "EditFamilyRequestParam{" +
                    "name='" + name + '\'' +
                    ", relation='" + relation + '\'' +
                    ", phone='" + phone + '\'' +
                    ", id='" + id + '\'' +
                    ", file='" + file + '\'' +
                    '}';
        }
    }

    public static class AddFamilyRequestParam {
        public String name;
        public String relation;
        public String phone;
        public String file;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRelation() {
            return relation;
        }

        public void setRelation(String relation) {
            this.relation = relation;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public AddFamilyRequestParam(String name, String relation, String phone, String file) {
            this.name = name;
            this.relation = relation;
            this.phone = phone;
            this.file = file;
        }

        @Override
        public String toString() {
            return "EditFamilyRequestParam{" +
                    "name='" + name + '\'' +
                    ", relation='" + relation + '\'' +
                    ", phone='" + phone + '\'' +
                    ", file='" + file + '\'' +
                    '}';
        }
    }
}
