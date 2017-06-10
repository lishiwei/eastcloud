package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.EastcloudRetrofit;
import com.orientalfinance.eastcloud.module.Retrofit.MyTransform;
import com.orientalfinance.eastcloud.module.core.CommonRequestParam;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.RegistView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ActivityRegistPresenter extends MvpNullObjectBasePresenter<RegistView> {
    private static final String TAG = ActivityRegistPresenter.class.getSimpleName();

    @Override
    public void attachView(RegistView view) {

    }

    @Override
    public void detachView(boolean retainInstance) {

    }

    public void login(CommonRequestParam commonRequestParam) {
        getView().showRegist();
        EastcloudRetrofit.getInstance().getEastCloudService().login(commonRequestParam.getS(), commonRequestParam.getSn()).compose(new MyTransform<User>()).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                getView().showError(throwable);
            }
        }).subscribe(new Consumer<User>() {
            @Override
            public void accept(User user) throws Exception {
                getView().registSucceed(user);
            }
        });
    }

    public void start() {


    }
}
