package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;


/**
 * Created by 29435 on 2017/5/26.
 */

public interface VerificationCodeView extends MvpView {


    void showGetCode();

    void hideGetCode();

    void showError(String errorMsg);

    void getCodeSucceed(String code);

    void verificateSucceed();
}
