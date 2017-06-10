package com.orientalfinance.eastcloud.module.javabean;

/**
 * Created by 29435 on 2017/6/10.
 */

public class FamilyMember {
    String userAvatar;
    String  relation;

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
}
