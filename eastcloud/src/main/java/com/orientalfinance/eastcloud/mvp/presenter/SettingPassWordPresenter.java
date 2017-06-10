package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.EastcloudRetrofit;
import com.orientalfinance.eastcloud.module.Retrofit.MyTransform;
import com.orientalfinance.eastcloud.module.core.CommonRequestParam;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.SettingPassWordView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class SettingPassWordPresenter extends MvpNullObjectBasePresenter<SettingPassWordView> {
    private static final String TAG = SettingPassWordPresenter.class.getSimpleName();

    @Override
    public void attachView(SettingPassWordView view) {

    }

    @Override
    public void detachView(boolean retainInstance) {

    }

    public void login(CommonRequestParam commonRequestParam) {
        getView().showgSettingPassWord();
        EastcloudRetrofit.getInstance().getEastCloudService().login(commonRequestParam.getS(), commonRequestParam.getSn()).compose(new MyTransform<User>()).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                getView().showError(throwable);
            }
        }).subscribe(new Consumer<User>() {
            @Override
            public void accept(User user) throws Exception {
                getView().SettingPassWordSucceed();
            }
        });
    }

    public void start() {


    }
}
