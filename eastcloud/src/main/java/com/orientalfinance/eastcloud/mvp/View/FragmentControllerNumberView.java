package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by lzy on 2017/6/28.
 * email:lizy@oriental-finance.com
 */

public interface FragmentControllerNumberView extends MvpView {
    void onSuccess(String successMsg);

    void onError(String errorMsg);

}
