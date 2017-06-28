package com.orientalfinance.eastcloud.module.javabean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.orientalfinance.eastcloud.module.BR;

/**
 * Created by 29435 on 2017/6/18.
 */

public class HomepageProgram  extends BaseObservable{
    @SerializedName("program_id")
    String programId;
    @SerializedName("show_img")
    String imageUrl;
    @SerializedName("name")
    String programeName;
    @SerializedName("intro")
    String programeIntroduce;
    @SerializedName("channel_id")
    String channelId;

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }
    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        notifyPropertyChanged(BR.imageUrl);

        this.imageUrl = imageUrl;
    }
    @Bindable
    public String getProgrameName() {
        return programeName;
    }

    public void setProgrameName(String programeName) {
        notifyPropertyChanged(BR.programeName);

        this.programeName = programeName;
    }
    @Bindable
    public String getProgrameIntroduce() {
        return programeIntroduce;
    }

    public void setProgrameIntroduce(String programeIntroduce) {
        notifyPropertyChanged(BR.programeIntroduce);

        this.programeIntroduce = programeIntroduce;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public HomepageProgram() {
    }

    public HomepageProgram(String programId, String imageUrl, String programeName, String programeIntroduce, String channelId) {
        this.programId = programId;
        this.imageUrl = imageUrl;
        this.programeName = programeName;
        this.programeIntroduce = programeIntroduce;
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "CurrentHit{" +
                "programId='" + programId + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", programeName='" + programeName + '\'' +
                ", programeIntroduce='" + programeIntroduce + '\'' +
                ", channelId='" + channelId + '\'' +
                '}';
    }
}
