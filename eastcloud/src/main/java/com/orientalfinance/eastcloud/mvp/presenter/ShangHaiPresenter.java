package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.HomePageChannel;
import com.orientalfinance.eastcloud.mvp.View.ShangHaiView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ShangHaiPresenter extends MvpNullObjectBasePresenter<ShangHaiView> {
    @Inject
    public ShangHaiPresenter() {
    }
    public void showChannelList(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.showChanneList(requestParam).compose(new ListTransform<List<HomePageChannel>>()).subscribe(new Consumer<List<HomePageChannel>>() {
            @Override
            public void accept(@NonNull List<HomePageChannel> homePageChannels) throws Exception {
                getView().hideDialog();
                getView().showChannelList(homePageChannels);
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
