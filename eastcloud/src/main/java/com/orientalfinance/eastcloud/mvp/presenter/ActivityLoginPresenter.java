package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.EastcloudRetrofit;
import com.orientalfinance.eastcloud.module.Retrofit.HttpCallBack;
import com.orientalfinance.eastcloud.module.Retrofit.MyTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.core.CommonRequestParam;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.LoginView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ActivityLoginPresenter extends MvpNullObjectBasePresenter<LoginView> {
    private static final String TAG = ActivityLoginPresenter.class.getSimpleName();

    @Override
    public void attachView(LoginView view) {

    }

    @Override
    public void detachView(boolean retainInstance) {

    }

    public void login(CommonRequestParam commonRequestParam) {
        getView().showLogin();
        RemoteDataProxy.login(new RequestParam(), new HttpCallBack<User>() {
            @Override
            public void OnSuccess(User data) {

            }

            @Override
            public void onFailure(String errorMsg) {

            }

            @Override
            public void onCompleted() {

            }
        });
        EastcloudRetrofit.getInstance().getEastCloudService()
                .login(commonRequestParam.getS(), commonRequestParam.getSn())
                .compose(new MyTransform<User>())
                .doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                getView().showError(throwable);
            }
        }).subscribe(new Consumer<User>() {
            @Override
            public void accept(User user) throws Exception {
                getView().loginSucceed(user);
            }
        });
    }

    public void start() {


    }
}
