package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.orientalfinance.eastcloud.module.javabean.User;


/**
 * Created by 29435 on 2017/5/26.
 */

public interface LoginView extends MvpView{


    public void showLogin();
    public void showError(Throwable throwable);
public void loginSucceed(User movie);

}
