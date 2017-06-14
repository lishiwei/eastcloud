package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.orientalfinance.eastcloud.module.javabean.Address;

import java.util.List;

/**
 * Created by lzy on 2017/6/14.
 * email:lizy@oriental-finance.com
 */

public interface ActivityMyAddressView extends MvpView {

    void showLoading();

    void showSuccess(List<Address> addressList);

    void showError(String errorMsg);
    void hideLoading();
}
