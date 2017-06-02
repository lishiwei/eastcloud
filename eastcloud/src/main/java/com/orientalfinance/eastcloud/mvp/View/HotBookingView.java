package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.orientalfinance.eastcloud.module.Detail;
import com.orientalfinance.eastcloud.module.Movie;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface HotBookingView extends MvpView{

    public void showView();
    public void showLoading();
    public void hideLoading();
    public void showExchange();
    public void stopExchange();
    public void exchangeHotMovie(List<Movie> movieList);
    public void exchangeHotVariety(List<Movie> movieList);
}
