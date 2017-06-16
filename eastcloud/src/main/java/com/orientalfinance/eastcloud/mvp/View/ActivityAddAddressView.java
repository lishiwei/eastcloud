package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by lzy on 2017/6/14.
 * email:lizy@oriental-finance.com
 */
public interface ActivityAddAddressView extends MvpView {
    void showDialog();
    void hideDialog();
    void showError(String errorMsg);
    void commitSucceed();
}
