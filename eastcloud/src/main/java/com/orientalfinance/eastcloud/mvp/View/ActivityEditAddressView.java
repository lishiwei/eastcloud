package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.orientalfinance.eastcloud.module.javabean.User;

/**
 * Created by lzy on 2017/6/12.
 * email:lizy@oriental-finance.com
 */

public interface ActivityEditAddressView extends MvpView {

    public void showSave();

    public void showDelete();

    public void showError(Throwable throwable);

    public void saveSucceed(User movie);

    public void deleteSuccess();
}
