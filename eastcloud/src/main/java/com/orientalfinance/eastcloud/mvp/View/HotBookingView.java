package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.orientalfinance.eastcloud.module.Detail;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface HotBookingView extends MvpView{

    public void showView();
    public void showLoading();
    public void hideLoading();
}
