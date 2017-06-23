package com.orientalfinance.eastcloud.module.javabean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.orientalfinance.eastcloud.module.BR;

import java.util.List;

/**
 * Created by 29435 on 2017/5/31.
 */

public class Detail extends BaseObservable{
    @SerializedName("program_id")
    String programId;
    @SerializedName("show_img")
    String url;
    @SerializedName("name")
    String title;

    String director;
    String actor;
    String year;
    String times;
    String score;

    @SerializedName("intro")
    String profile;
    @SerializedName("channel_id")
    String channelId;
    @SerializedName("air_time")
    String airTime;

    List<Comment> mComments;

    public Detail(String url, String title, String director, String actor, String year, String times, String score, String profile, List<Comment> comments) {
        this.url = url;
        this.title = title;
        this.director = director;
        this.actor = actor;
        this.year = year;
        this.times = times;
        this.score = score;
        this.profile = profile;
        mComments = comments;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getAirTime() {
        return airTime;
    }

    public void setAirTime(String airTime) {
        this.airTime = airTime;
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }
    @Bindable

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        notifyPropertyChanged(BR.title);
        this.title = title;
    }
    @Bindable

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        notifyPropertyChanged(BR.director);
        this.director = director;
    }
    @Bindable

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
        notifyPropertyChanged(BR.actor);
    }
    @Bindable

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
        notifyPropertyChanged(BR.year);
    }
    @Bindable

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        notifyPropertyChanged(BR.times);
        this.times = times;
    }
    @Bindable

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
        notifyPropertyChanged(BR.score);
    }
    @Bindable

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        notifyPropertyChanged(BR.profile);
        this.profile = profile;
    }


    public List<Comment> getComments() {
        return mComments;
    }

    public void setComments(List<Comment> comments) {
        mComments = comments;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", actor='" + actor + '\'' +
                ", year='" + year + '\'' +
                ", times='" + times + '\'' +
                ", score='" + score + '\'' +
                ", profile='" + profile + '\'' +
                ", mComments=" + mComments +
                '}';
    }
    public static class ShowDetailRequestParam{
        String program_id;

        public String getProgram_id() {
            return program_id;
        }

        public void setProgram_id(String program_id) {
            this.program_id = program_id;
        }

        public ShowDetailRequestParam(String program_id) {
            this.program_id = program_id;
        }

        @Override
        public String toString() {
            return "ShowDetailRequestParam{" +
                    "program_id='" + program_id + '\'' +
                    '}';
        }
    }
}
