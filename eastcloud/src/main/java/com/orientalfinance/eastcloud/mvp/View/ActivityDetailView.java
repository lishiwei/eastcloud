package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.orientalfinance.eastcloud.module.Detail;
import com.orientalfinance.eastcloud.module.Movie;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface ActivityDetailView extends MvpView{

    public void showView(Detail detail);
    public void showLoading();
    public void hideLoading();
}
