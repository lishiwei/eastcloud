package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.orientalfinance.eastcloud.module.javabean.User;

/**
 * Created by lzy on 2017/6/12.
 * email:lizy@oriental-finance.com
 */

public interface ManagerAddressView extends MvpView {
    public void showLogin();
    public void showError(Throwable throwable);
    public void loginSucceed(User movie);
}
