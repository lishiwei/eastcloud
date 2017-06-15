package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.HttpCallBack;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.LoginView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;
import com.orientalfinance.eastcloud.utils.LogUtils;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ActivityLoginPresenter extends MvpNullObjectBasePresenter<LoginView> {
    private static final String TAG = ActivityLoginPresenter.class.getSimpleName();


    public void login(RequestParam requestParam) {
        getView().showLogin();


        RemoteDataProxy.login(requestParam, new HttpCallBack<User>() {
            @Override
            public void OnSuccess(User data) {
                LogUtils.d(TAG, "OnSuccess: " + data.toString());
                getView().hideLogin();
                getView().loginSucceed(data);
            }

            @Override
            public void onFailure(String errorMsg) {
                LogUtils.d(TAG, "onFailure: " + errorMsg);
                getView().hideLogin();
                getView().showError(errorMsg);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

}
