package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.orientalfinance.eastcloud.module.javabean.TV;

import java.util.List;

/**
 * Created by 29435 on 2017/6/2.
 */

public interface MyTVView extends MvpView {
    void showTVBox(List<TV> list);

    void showLoading();

    void hideLoading();

    void showError(String errorMsg);
    void showDelectTVBox();
    void delectSucceed();
}
