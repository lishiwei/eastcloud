package com.orientalfinance.eastcloud.mvp.View;

/**
 * Created by 29435 on 2017/6/2.
 */

public interface BaseMvpView {
    public void showLoading();
    public void hideLoading();
    public void showError(Throwable throwable);
}
