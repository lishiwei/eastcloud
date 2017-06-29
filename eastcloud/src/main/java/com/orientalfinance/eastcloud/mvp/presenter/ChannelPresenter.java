package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.ChannelCategory;
import com.orientalfinance.eastcloud.module.javabean.HomePageChannel;
import com.orientalfinance.eastcloud.mvp.View.ChannelView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ChannelPresenter extends MvpNullObjectBasePresenter<ChannelView> {
    @Inject
    public ChannelPresenter() {
    }


    public void start() {

    }

    public void showChannelCategory(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.showChannelCatelog(requestParam).compose(new ListTransform<List<ChannelCategory>>()).subscribe(new Consumer<List<ChannelCategory>>() {
            @Override
            public void accept(@NonNull List<ChannelCategory> catalogs) throws Exception {
                getView().hideDialog();
                getView().showChannelCategory(catalogs);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();
            }
        });
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

