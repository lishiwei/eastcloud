package com.orientalfinance.eastcloud.module;

/**
 * Created by 29435 on 2017/5/26.
 */

public class Movie {
    String imageUrl;
    String title;
    String tag;

    public Movie(String imageUrl, String title, String tag) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;

        Movie movie = (Movie) o;

        if (getImageUrl() != null ? !getImageUrl().equals(movie.getImageUrl()) : movie.getImageUrl() != null)
            return false;
        if (getTitle() != null ? !getTitle().equals(movie.getTitle()) : movie.getTitle() != null)
            return false;
        return getTag() != null ? getTag().equals(movie.getTag()) : movie.getTag() == null;

    }

    @Override
    public int hashCode() {
        int result = getImageUrl() != null ? getImageUrl().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getTag() != null ? getTag().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", tag='" + tag + '\'' +
                '}';
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
