package com.orientalfinance.eastcloud.module.javabean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.orientalfinance.eastcloud.module.BR;

import java.util.List;

/**
 * Created by 29435 on 2017/5/31.
 */

public class Detail extends BaseObservable{
    String url;
    String title;
    String director;
    String actor;
    String year;
    String times;
    String score;
    String profile;
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
}
