package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.EastcloudRetrofit;
import com.orientalfinance.eastcloud.module.Retrofit.ObjectTransform;
import com.orientalfinance.eastcloud.module.core.CommonRequestParam;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.VerificationCodeView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ActivityVerificationCodePresenter extends MvpNullObjectBasePresenter<VerificationCodeView> {
    private static final String TAG = ActivityVerificationCodePresenter.class.getSimpleName();


    public void sendVerificationCode(CommonRequestParam commonRequestParam) {
        getView().showGetCode();
        EastcloudRetrofit.getInstance().getEastCloudService().login(commonRequestParam.getS(), commonRequestParam.getSn()).compose(new ObjectTransform<User>()).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                getView().hideGetCode();
                getView().showError(throwable);
            }
        }).subscribe(new Consumer<User>() {
            @Override
            public void accept(User user) throws Exception {
                getView().hideGetCode();
                getView().getCodeSucceed();
            }
        });
    }

    public void start() {
        sendVerificationCode(null);

    }
}
