package com.orientalfinance.eastcloud.module;

/**
 * Created by 29435 on 2017/5/26.
 */

public class Movie {
    String imageUrl;
    String title;
    String tag;
int progress;
    public Movie(String imageUrl, String title, String tag) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.tag = tag;
    }

    public Movie(String imageUrl, String title, String tag, int progress) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.tag = tag;
        this.progress = progress;
    }



    @Override
    public String toString() {
        return "Movie{" +
                "imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", tag='" + tag + '\'' +
                ", progress='" + progress + '\'' +
                '}';
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
