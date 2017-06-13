package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.EastcloudRetrofit;
import com.orientalfinance.eastcloud.module.Retrofit.ObjectTransform;
import com.orientalfinance.eastcloud.module.core.CommonRequestParam;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.ModifyPassWordView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ModifyPassWordPresenter extends MvpNullObjectBasePresenter<ModifyPassWordView> {
    private static final String TAG = ModifyPassWordPresenter.class.getSimpleName();


    public void regist(CommonRequestParam commonRequestParam) {
        getView().showModify();
        EastcloudRetrofit.getInstance().getEastCloudService().login(commonRequestParam.getS(), commonRequestParam.getSn()).compose(new ObjectTransform<User>()).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                getView().hideModify();
                getView().showError(throwable);
            }
        }).subscribe(new Consumer<User>() {
            @Override
            public void accept(User user) throws Exception {
                getView().ModifySucceed(user);
            }
        });
    }

    @Override
    public void start() {

    }
}
