package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.HttpCallBack;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Register;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.SettingPassWordView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

/**
 * Created by 29435 on 2017/5/26.
 */

public class SettingPassWordPresenter extends MvpNullObjectBasePresenter<SettingPassWordView> {
    private static final String TAG = SettingPassWordPresenter.class.getSimpleName();


    public void register(String phone, String pwd) {

        getView().showRegist();
        Register register = new Register(phone, pwd);
        RemoteDataProxy.register(new RequestParam<Register>(register), new HttpCallBack<User>() {
            @Override
            public void OnSuccess(User data) {
                getView().hideRegist();
                getView().registSucceed(data);
            }

            @Override
            public void onFailure(String errorMsg) {
                getView().hideRegist();
                getView().showError(errorMsg);
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    public void start() {


    }
}
