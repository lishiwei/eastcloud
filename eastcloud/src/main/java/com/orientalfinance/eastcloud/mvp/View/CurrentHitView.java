package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.orientalfinance.eastcloud.module.Movie;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface CurrentHitView extends MvpView{

    public void showView(List<Movie> movies);
    public void showLoading();
    public void hideLoading();
}
