package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Address;
import com.orientalfinance.eastcloud.mvp.View.ActivityMyAddressView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by lzy on 2017/6/14.
 * email:lizy@oriental-finance.com
 */

public class ActivityMyAddressPresenter extends MvpNullObjectBasePresenter<ActivityMyAddressView> {

    public void start() {

    }

    public void getAddress(RequestParam requestParam) {
        getView().showLoading();
        RemoteDataProxy.getAddress(requestParam).compose(new ListTransform<List<Address>>()).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                getView().hideLoading();
                getView().showError(throwable.getMessage());
            }
        }).subscribe(new Consumer<List<Address>>() {
            @Override
            public void accept(List<Address> addresses) throws Exception {
                getView().hideLoading();
                getView().showSuccess(addresses);
            }
        });
    }
}
