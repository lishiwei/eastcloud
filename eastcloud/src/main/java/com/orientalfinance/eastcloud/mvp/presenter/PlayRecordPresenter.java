package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Channel;
import com.orientalfinance.eastcloud.mvp.View.PlayRecordView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class PlayRecordPresenter extends MvpNullObjectBasePresenter<PlayRecordView> {
    private static final String TAG = PlayRecordPresenter.class.getSimpleName();


    @Inject
    public PlayRecordPresenter() {
    }

    public void showHistory(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.showHistory(requestParam).compose(new ListTransform<List<Channel>>()).subscribe(new Consumer<List<Channel>>() {
            @Override
            public void accept(@NonNull List<Channel> channels) throws Exception {
                getView().hideDialog();
                getView().showHistory(channels);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);

            }
        });

    }
}
