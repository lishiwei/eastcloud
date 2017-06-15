package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.NullTransform;
import com.orientalfinance.eastcloud.module.Retrofit.ObjectTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Message;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.VerificationCodeView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;
import com.orientalfinance.eastcloud.utils.ValidateUtils;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ActivityVerificationCodePresenter extends MvpNullObjectBasePresenter<VerificationCodeView> {
    private static final String TAG = ActivityVerificationCodePresenter.class.getSimpleName();


    public void sendVerificationCode(RequestParam requestParam) {

        getView().showGetCode();
        if (!ValidateUtils.isMobileNO(((User.SendCodeRequestParam) requestParam.getData()).phone)) {
            getView().showError("您的手机号输入有误!");
            return;
        }

        RemoteDataProxy.codeSend(requestParam).compose(new ObjectTransform<Message>()).subscribe(new Consumer<Message>() {
            @Override
            public void accept(@NonNull Message message) throws Exception {
                getView().hideGetCode();
                getView().getCodeSucceed(message.getMsgId());
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
super.accept(throwable);
                getView().hideGetCode();

            }
        });
    }

    public void verificateCode(RequestParam requestParam) {
        getView().showGetCode();
        RemoteDataProxy.validateCode(requestParam).compose(new NullTransform()).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(@NonNull EastCloudResponseBody eastCloudResponseBody) throws Exception {
                if (Integer.valueOf(eastCloudResponseBody.getCode()) < 0) {
                    getView().hideGetCode();
                    getView().showError(eastCloudResponseBody.getMsg());
                } else {
                    getView().hideGetCode();
                    getView().verificateSucceed();
                }
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideGetCode();
            }
        });
    }

    public void start() {
//        sendVerificationCode(new CommonRequestParam("",""));

    }
}
