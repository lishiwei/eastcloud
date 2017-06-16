package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.orientalfinance.eastcloud.module.javabean.Detail;
import com.orientalfinance.eastcloud.module.javabean.Movie;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface BookingDetailView extends MvpView{
void getDetail(String detailId);
    void showView(Detail details);
    void showLoading();
    void hideLoading();
    void showExchange();
    void stopExchange();
    void exchangeHotMovie(List<Movie> movieList);
    void exchangeHotVariety(List<Movie> movieList);
}
