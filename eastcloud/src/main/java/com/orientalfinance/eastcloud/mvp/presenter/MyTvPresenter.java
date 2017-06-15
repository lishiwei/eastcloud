package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.TV;
import com.orientalfinance.eastcloud.mvp.View.MyTVView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;
import com.orientalfinance.eastcloud.utils.LogUtils;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 29435 on 2017/5/26.
 */

public class MyTvPresenter extends MvpNullObjectBasePresenter<MyTVView> {
    private static final String TAG = MyTvPresenter.class.getSimpleName();

    @Inject
    public MyTvPresenter() {
    }

    public void showTVBox(RequestParam requestParam) {

        getView().showLoading();
        RemoteDataProxy.showTvBoxList(requestParam).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).map(new Function<EastCloudResponseBody<List<TV>>, List<TV>>() {
            @Override
            public List<TV> apply(EastCloudResponseBody<List<TV>> tvResponseBody) throws Exception {
                return tvResponseBody.getResult();
            }
        }).subscribe(new Consumer<List<TV>>() {
                         @Override
                         public void accept(List<TV> list) throws Exception {
                             getView().hideLoading();
                             getView().showTVBox(list);
                         }
                     }
                , new MyConsumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        super.accept(throwable);
                        getView().hideLoading();
                        LogUtils.e(TAG, "accept: "+throwable.toString());
                    }
                });

    }

    public void delTVBox(final RequestParam requestParam) {

        getView().showDelectTVBox();
        RemoteDataProxy.delTvBox(requestParam).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).map(new Function<EastCloudResponseBody, String>() {
            @Override
            public String apply(EastCloudResponseBody eastCloudResponseBody) throws Exception {
                return eastCloudResponseBody.getCode();
            }
        })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        getView().hideLoading();
                        getView().delectSucceed();
                    }
                }, new MyConsumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        super.accept(throwable);
                        getView().hideLoading();
                    }
                });

    }

    public void scanTVBox(RequestParam requestParam) {

        getView().showLoading();
        RemoteDataProxy.scanTvBox(requestParam).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).map(new Function<EastCloudResponseBody<List<TV>>, List<TV>>() {
            @Override
            public List<TV> apply(EastCloudResponseBody<List<TV>> tvEastCloudResponseBody) throws Exception {
                return tvEastCloudResponseBody.getResult();
            }
        }).subscribe(new Consumer<List<TV>>() {
            @Override
            public void accept(List<TV> tvList) throws Exception {
                getView().hideLoading();
                getView().showTVBox(tvList);
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
