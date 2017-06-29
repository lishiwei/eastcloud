package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Application;
import com.orientalfinance.eastcloud.mvp.View.ApplicationView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ApplicationPresenter extends MvpNullObjectBasePresenter<ApplicationView> {
    @Inject
    public ApplicationPresenter() {

    }

    public void getApplication(RequestParam requestParam) {
        RemoteDataProxy.showAppList(requestParam).compose(new ListTransform<List<Application>>()).subscribe(new Consumer<List<Application>>() {
            @Override
            public void accept(@NonNull List<Application> applications) throws Exception {

            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);

            }
        });
    }
}
