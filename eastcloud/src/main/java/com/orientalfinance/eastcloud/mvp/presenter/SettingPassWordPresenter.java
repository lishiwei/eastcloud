package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Register;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.SettingPassWordView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 29435 on 2017/5/26.
 */

public class SettingPassWordPresenter extends MvpNullObjectBasePresenter<SettingPassWordView> {
    private static final String TAG = SettingPassWordPresenter.class.getSimpleName();


    public void register(String phone, String pwd) {

        getView().showRegist();
        Register register = new Register(phone, pwd);
        RemoteDataProxy.register(new RequestParam<Register>(register)).compose(new FlowableTransformer<EastCloudResponseBody<User>, User>() {
            @Override
            public Publisher<User> apply(Flowable<EastCloudResponseBody<User>> upstream) {
                return upstream.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).map(new Function<EastCloudResponseBody<User>, User>() {
                    @Override
                    public User apply(EastCloudResponseBody<User> tEastCloudResponseBody) throws Exception {
                        if (tEastCloudResponseBody.getResult()!=null)
                        {
                            return tEastCloudResponseBody.getResult();
                        }
                        else {
                            return new User();
                        }

                    }
                });
            }
        }).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                getView().hideRegist();
                getView().showError(throwable.getMessage());
            }
        }).subscribe(new Consumer<User>() {
            @Override
            public void accept(User user) throws Exception {
                if (user.getName()==null) {
                    getView().hideRegist();
                    getView().showError("该手机号已注册");
                } else {
                    getView().hideRegist();
                    getView().registSucceed(user);
                }

            }
        });

    }

    public void start() {


    }
}
