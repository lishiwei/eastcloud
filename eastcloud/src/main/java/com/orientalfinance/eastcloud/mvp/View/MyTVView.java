package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.orientalfinance.eastcloud.module.javabean.TV;

import java.util.List;

/**
 * Created by 29435 on 2017/6/2.
 */

public interface MyTVView extends MvpView {
    public void showTVBox(List<TV> list);

    public void showLoading();

    public void hideLoading();

    public void showError(String errorMsg);
}
