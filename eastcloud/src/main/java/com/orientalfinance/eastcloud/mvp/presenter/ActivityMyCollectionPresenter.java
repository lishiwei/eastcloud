package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.NullTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Collection;
import com.orientalfinance.eastcloud.mvp.View.ActivityMyCollectionView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by lzy on 2017/6/15.
 * email:lizy@oriental-finance.com
 */

public class ActivityMyCollectionPresenter extends MvpNullObjectBasePresenter
        <ActivityMyCollectionView> {
    public void showCollection(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.showMyCollection(requestParam).compose(new ListTransform<List<Collection>>()).subscribe(new Consumer<List<Collection>>() {
            @Override
            public void accept(@NonNull List<Collection> collections) throws Exception {
                getView().hideDialog();
                getView().showCollection(collections);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();

            }
        });
    }

    public void deleteCollection(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.deleteMyCollection(requestParam).compose(new NullTransform()).subscribe(new Consumer<EastCloudResponseBody>() {
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
            }
        });
    }
}
