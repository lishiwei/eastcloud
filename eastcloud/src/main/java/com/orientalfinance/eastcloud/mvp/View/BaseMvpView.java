package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by 29435 on 2017/6/2.
 */

public interface BaseMvpView extends MvpView{
    public void showDialog();
    public void hideDialog();
    public void showError(String errorMsg);

}
