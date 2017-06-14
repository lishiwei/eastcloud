package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.NullTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.mvp.View.ActivityAddAddressView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import io.reactivex.functions.Consumer;

/**
 * Created by lzy on 2017/6/14.
 * email:lizy@oriental-finance.com
 */

public class ActivityAddAddressPresenter extends MvpNullObjectBasePresenter<ActivityAddAddressView> {

    public void start() {

    }

    public void addAddress(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.addAddress(requestParam).compose(new NullTransform()).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                getView().hideDialog();
                getView().showError(throwable.getMessage());
            }
        }).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(EastCloudResponseBody eastCloudResponseBody) throws Exception {
                if (Integer.valueOf(eastCloudResponseBody.getCode()) < 0) {
                    getView().hideDialog();
                    getView().showError(eastCloudResponseBody.getMsg());

                }
                else {
                    getView().hideDialog();
                    getView().commitSucceed();
                }
            }
        });
    }
}
