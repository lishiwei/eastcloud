package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;


/**
 * Created by 29435 on 2017/5/26.
 */

public interface SettingPassWordView extends MvpView {


    public void showgSettingPassWord();

    public void showError(Throwable throwable);

    public void SettingPassWordSucceed();

}
