package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.NullTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.History;
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
        RemoteDataProxy.showHistory(requestParam).compose(new ListTransform<List<History>>()).subscribe(new Consumer<List<History>>() {
            @Override
            public void accept(@NonNull List<History> histories) throws Exception {
                getView().hideDialog();
                getView().showHistory(histories);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();
            }
        });

    }

    public void deleteHistory(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.deleteHistory(requestParam).compose(new NullTransform()).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(@NonNull EastCloudResponseBody eastCloudResponseBody) throws Exception {
                getView().hideDialog();
                getView().deleteSucceed(0);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();
                getView().deleteFailed(0);

            }
        });
    }
}
