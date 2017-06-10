package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.EastcloudRetrofit;
import com.orientalfinance.eastcloud.module.Retrofit.MyTransform;
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

    @Override
    public void attachView(ModifyPassWordView view) {

    }

    @Override
    public void detachView(boolean retainInstance) {

    }

    public void login(CommonRequestParam commonRequestParam) {
        getView().showgModifyPassWord();
        EastcloudRetrofit.getInstance().getEastCloudService().login(commonRequestParam.getS(), commonRequestParam.getSn()).compose(new MyTransform<User>()).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                getView().showError(throwable);
            }
        }).subscribe(new Consumer<User>() {
            @Override
            public void accept(User user) throws Exception {
                getView().modifyPassWordSucceed();
            }
        });
    }

    public void start() {


    }
}
