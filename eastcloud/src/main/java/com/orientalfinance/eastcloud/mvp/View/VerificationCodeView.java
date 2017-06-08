package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.orientalfinance.eastcloud.module.javabean.User;


/**
 * Created by 29435 on 2017/5/26.
 */

public interface VerificationCodeView extends MvpView {


    public void showgGetCode();

    public void showError(Throwable throwable);

    public void getCodeSucceed(User movie);

}
