package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.NullTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Address;
import com.orientalfinance.eastcloud.mvp.View.ActivityAddAddressView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;
import com.orientalfinance.eastcloud.utils.ValidateUtils;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by lzy on 2017/6/14.
 * email:lizy@oriental-finance.com
 */

public class AddAddressPresenter extends MvpNullObjectBasePresenter<ActivityAddAddressView> {

    public void start() {

    }

    public void addAddress(RequestParam requestParam) {

        Address.AddRequestParam  addRequestParam = (Address.AddRequestParam) requestParam.getData();
        if (!ValidateUtils.isMobileNO(addRequestParam.getPhone()))
        {
            getView().showError("您的手机号码不正确！");
            return;
        }
        getView().showDialog();
        RemoteDataProxy.addAddress(requestParam).compose(new NullTransform()).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(EastCloudResponseBody eastCloudResponseBody) throws Exception {
                if (Integer.valueOf(eastCloudResponseBody.getCode()) < 0) {
                    getView().hideDialog();
                    getView().showError(eastCloudResponseBody.getMsg());

                } else {
                    getView().hideDialog();
                    getView().commitSucceed();
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                getView().hideDialog();
                getView().showError("网络连接失败");
            }
        });
    }
}
