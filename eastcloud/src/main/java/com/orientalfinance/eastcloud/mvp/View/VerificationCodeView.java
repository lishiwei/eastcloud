package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;


/**
 * Created by 29435 on 2017/5/26.
 */

public interface VerificationCodeView extends MvpView {


    public void showGetCode();

    public void hideGetCode();

    public void showError(String errorMsg);

    public void getCodeSucceed(String code);

    public void verificateSucceed();
}
