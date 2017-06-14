package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.core.CommonRequestParam;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.LoginView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ActivityLoginPresenter extends MvpNullObjectBasePresenter<LoginView> {
    private static final String TAG = ActivityLoginPresenter.class.getSimpleName();


    public void login(CommonRequestParam commonRequestParam) {
        getView().showLogin();
        User user = new User();
        user.setPwd("123456");
        user.setName("lishiwei");
        user.setPhone("18601704731");
        getView().hideLogin();
        getView().loginSucceed(user);
//        EastcloudRetrofit.getInstance().getEastCloudService()
//                .login(commonRequestParam.getS(), commonRequestParam.getSn())
//                .compose(new ObjectTransform<User>())
//                .doOnError(new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                getView().showError(throwable);
//            }
//        }).subscribe(new Consumer<User>() {
//            @Override
//            public void accept(User user) throws Exception {
//                getView().loginSucceed(user);
//            }
//        });
    }

    public void start() {


    }
}
