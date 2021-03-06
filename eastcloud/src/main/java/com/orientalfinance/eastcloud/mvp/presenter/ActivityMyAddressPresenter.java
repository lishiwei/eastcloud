package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Address;
import com.orientalfinance.eastcloud.mvp.View.ActivityMyAddressView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;
import com.orientalfinance.eastcloud.utils.LogUtils;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by lzy on 2017/6/14.
 * email:lizy@oriental-finance.com
 */

public class ActivityMyAddressPresenter extends MvpNullObjectBasePresenter<ActivityMyAddressView> {
    static String TAG = ActivityMyAddressPresenter.class.getSimpleName();

    public void start() {

    }


    public void getAddress(RequestParam requestParam) {
        LogUtils.e(TAG, "getAddress: ");
        getView().showLoading();
        RemoteDataProxy.getAddress(requestParam).compose(new ListTransform<List<Address>>())
                .subscribe(new Consumer<List<Address>>() {
                    @Override
                    public void accept(List<Address> addresses) throws Exception {
                        getView().hideLoading();
                        getView().showSuccess(addresses);
                    }
                }, new MyConsumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        super.accept(throwable);
                        getView().hideLoading();
                    }
                });
    }
}
