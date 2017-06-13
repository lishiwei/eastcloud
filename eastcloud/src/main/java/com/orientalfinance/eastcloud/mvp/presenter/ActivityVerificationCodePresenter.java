package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.HttpCallBack;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.VerificationCode;
import com.orientalfinance.eastcloud.mvp.View.VerificationCodeView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;
import com.orientalfinance.eastcloud.utils.ValidateUtils;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ActivityVerificationCodePresenter extends MvpNullObjectBasePresenter<VerificationCodeView> {
    private static final String TAG = ActivityVerificationCodePresenter.class.getSimpleName();


    public void sendVerificationCode(String phone) {
        getView().showGetCode();
        if (!ValidateUtils.isMobileNO(phone)) {
            getView().showError("您的手机号输入有误!");
            return;
        }
        RemoteDataProxy.codeSend(new RequestParam<String>(phone), new HttpCallBack<String>() {
            @Override
            public void OnSuccess(String data) {
                getView().hideGetCode();
                getView().getCodeSucceed(data);
            }

            @Override
            public void onFailure(String errorMsg) {

                getView().hideGetCode();
                getView().showError(errorMsg);
            }

            @Override
            public void onCompleted() {

            }
        });

//
//        EastcloudRetrofit.getInstance().getEastCloudService().login(commonRequestParam.getS(), commonRequestParam.getSn()).compose(new ObjectTransform<User>()).doOnError(new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                getView().hideGetCode();
//                getView().showError(throwable);
//            }
//        }).subscribe(new Consumer<User>() {
//            @Override
//            public void accept(User user) throws Exception {
//                getView().hideGetCode();
//                getView().getCodeSucceed();
//            }
//        });
    }

    public void verificateCode(VerificationCode verificationCode) {
        getView().showGetCode();
        RemoteDataProxy.validateCode(new RequestParam<VerificationCode>(verificationCode), new HttpCallBack() {
            @Override
            public void OnSuccess(Object data) {
                getView().hideGetCode();
                getView().verificateSucceed();
            }

            @Override
            public void onFailure(String errorMsg) {
                getView().hideGetCode();
                getView().showError(errorMsg);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    public void start() {
//        sendVerificationCode(new CommonRequestParam("",""));

    }
}
