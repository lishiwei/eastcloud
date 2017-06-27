package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by lzy on 2017/6/27.
 * email:lizy@oriental-finance.com
 */

public interface FragmentRemoteControlView extends MvpView {
    void onSuccess(String successMsg);

    void onError(String errorMsg);
}
