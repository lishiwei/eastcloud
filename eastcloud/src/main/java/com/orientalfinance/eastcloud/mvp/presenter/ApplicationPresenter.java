package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Application;
import com.orientalfinance.eastcloud.module.javabean.Banner;
import com.orientalfinance.eastcloud.mvp.View.ApplicationView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;
import com.orientalfinance.eastcloud.utils.LogUtils;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ApplicationPresenter extends MvpNullObjectBasePresenter<ApplicationView> {
    public static String TAG = ApplicationPresenter.class.getSimpleName();
    @Inject
    public ApplicationPresenter() {

    }

    public void getApplicationList(RequestParam requestParam) {
        RemoteDataProxy.showAppList(requestParam).compose(new ListTransform<List<Application>>()).subscribe(new Consumer<List<Application>>() {
            @Override
            public void accept(@NonNull List<Application> applications) throws Exception {
                LogUtils.d(TAG, "accept: "+applications.toString());
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().showError(throwable.getMessage());

            }
        });
    }
    public void getApplicationBanner(RequestParam requestParam) {
        RemoteDataProxy.showAppBanner(requestParam).compose(new ListTransform<List<Banner>>()).subscribe(new Consumer<List<Banner>>() {
            @Override
            public void accept(@NonNull List<Banner> banners) throws Exception {
                LogUtils.d(TAG, "accept: "+banners.toString());
                getView().showAppBanner(banners);
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
