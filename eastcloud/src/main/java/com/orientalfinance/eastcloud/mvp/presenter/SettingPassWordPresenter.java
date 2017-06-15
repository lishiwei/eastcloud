package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.NullTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.SettingPassWordView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 29435 on 2017/5/26.
 */

public class SettingPassWordPresenter extends MvpNullObjectBasePresenter<SettingPassWordView> {
    private static final String TAG = SettingPassWordPresenter.class.getSimpleName();


    public void register(RequestParam requestParam) {
        getView().showRegist();
        RemoteDataProxy.register(requestParam).compose(new FlowableTransformer<EastCloudResponseBody<User>, User>() {
            @Override
            public Publisher<User> apply(Flowable<EastCloudResponseBody<User>> upstream) {
                return upstream.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).map(new Function<EastCloudResponseBody<User>, User>() {
                    @Override
                    public User apply(EastCloudResponseBody<User> tEastCloudResponseBody) throws Exception {

                        return tEastCloudResponseBody.getResult();

                    }
                });
            }
        }).subscribe(new Consumer<User>() {
            @Override
            public void accept(User user) throws Exception {
                    getView().hideRegist();
                    getView().registSucceed(user);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideRegist();

            }
        });

    }
    public void forgetPsd(RequestParam requestParam) {
        getView().showRegist();
        RemoteDataProxy.forgetPwd(requestParam).compose(new FlowableTransformer<EastCloudResponseBody<User>, User>() {
            @Override
            public Publisher<User> apply(Flowable<EastCloudResponseBody<User>> upstream) {
                return upstream.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).map(new Function<EastCloudResponseBody<User>, User>() {
                    @Override
                    public User apply(EastCloudResponseBody<User> tEastCloudResponseBody) throws Exception {

                        return tEastCloudResponseBody.getResult();

                    }
                });
            }
        }).subscribe(new Consumer<User>() {
            @Override
            public void accept(User user) throws Exception {

                    getView().hideRegist();
                    getView().registSucceed(user);

            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);

                getView().hideRegist();

            }
        });

    }
    public void modifyPsd(RequestParam requestParam) {
        getView().showRegist();
        RemoteDataProxy.updatePwd(requestParam).compose(new NullTransform()).subscribe(new Consumer<EastCloudResponseBody>() {
            @Override
            public void accept(EastCloudResponseBody eastCloudResponseBody) throws Exception {

                   getView().hideRegist();
                   getView().modifySucceed();

            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);

                getView().hideRegist();

            }
        });

    }

    public void start() {


    }
}
