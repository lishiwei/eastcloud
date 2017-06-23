package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.NullTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.mvp.View.ConfirmPayPwdView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;


public class ConfirmPayPwdPresenter extends MvpNullObjectBasePresenter<ConfirmPayPwdView> {


    public void commitBank(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.commitBank(requestParam).compose(new NullTransform()).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(@NonNull EastCloudResponseBody eastCloudResponseBody) throws Exception {
                getView().hideDialog();
                getView().commitSucceed(eastCloudResponseBody);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().showError(throwable.getMessage());
            }
        });
    }
}
