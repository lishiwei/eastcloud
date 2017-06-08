package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;


/**
 * Created by 29435 on 2017/5/26.
 */

public interface ModifyPassWordView extends MvpView {


    public void showgModifyPassWord();

    public void showError(Throwable throwable);

    public void modifyPassWordSucceed();

}
