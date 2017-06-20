package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.NullTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Address;
import com.orientalfinance.eastcloud.mvp.View.ActivityEditAddressView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;
import com.orientalfinance.eastcloud.utils.ValidateUtils;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by lzy on 2017/6/12.
 * email:lizy@oriental-finance.com
 */

public class ActivityEditAddressPresenter extends MvpNullObjectBasePresenter<ActivityEditAddressView> {
    public void start() {

    }

    public void editAddress(RequestParam requestParam) {
        Address.EditRequestParam  editRequestParam = (Address.EditRequestParam) requestParam.getData();
        if (!ValidateUtils.isMobileNO(editRequestParam.getPhone()))
        {
            getView().showError("您的手机号码不正确！");
            return;
        }
        getView().showDialog();
        RemoteDataProxy.editAddress(requestParam).compose(new NullTransform()).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(EastCloudResponseBody eastCloudResponseBody) throws Exception {
                getView().hideDialog();
                getView().editSucceed();

            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {

                getView().hideDialog();

            }
        });
    }

    public void deleteAddress(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.deleteAddress(requestParam).compose(new NullTransform()).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(EastCloudResponseBody eastCloudResponseBody) throws Exception {
                getView().hideDialog();
                    getView().deleteSuccess();

            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();

            }
        });
    }
}
