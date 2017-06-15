package com.orientalfinance.eastcloud.module.javabean;

/**
 * Created by lzy on 2017/6/15.
 * email:lizy@oriental-finance.com
 */

public class TVShowEntity {
    private String name;
    private String time;
    private String profile;
    private String logoUrl;
    private boolean isChecked;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        return "TVShowEntity{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", profile='" + profile + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", isChecked=" + isChecked +
                '}';
    }
}
