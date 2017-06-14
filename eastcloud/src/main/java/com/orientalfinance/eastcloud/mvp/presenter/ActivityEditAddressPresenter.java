package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.NullTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.mvp.View.ActivityEditAddressView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import io.reactivex.functions.Consumer;

/**
 * Created by lzy on 2017/6/12.
 * email:lizy@oriental-finance.com
 */

public class ActivityEditAddressPresenter extends MvpNullObjectBasePresenter<ActivityEditAddressView> {
    public void start() {

    }

    public void editAddress(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.editAddress(requestParam).compose(new NullTransform()).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                getView().hideDialog();
                getView().showError(throwable.getMessage());
            }
        }).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(EastCloudResponseBody eastCloudResponseBody) throws Exception {
                getView().hideDialog();
                if (Integer.valueOf(eastCloudResponseBody.getCode()) < 10) {
                    getView().showError(eastCloudResponseBody.getMsg());
                } else {
                    getView().editSucceed();
                }
            }
        });
    }

    public void deleteAddress(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.deleteAddress(requestParam).compose(new NullTransform()).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                getView().hideDialog();
                getView().showError(throwable.getMessage());
            }
        }).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(EastCloudResponseBody eastCloudResponseBody) throws Exception {
                getView().hideDialog();
                if (Integer.valueOf(eastCloudResponseBody.getCode()) < 10) {
                    getView().showError(eastCloudResponseBody.getMsg());
                } else {
                    getView().deleteSuccess();
                }
            }
        });
    }
}
