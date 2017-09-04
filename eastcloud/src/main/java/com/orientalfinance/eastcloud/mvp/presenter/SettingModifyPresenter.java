package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.ObjectTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.AvatarUrl;
import com.orientalfinance.eastcloud.mvp.View.SettingModifyView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class SettingModifyPresenter extends MvpNullObjectBasePresenter<SettingModifyView> {

    public void modifyUserInfo(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.modifyUserInfo(requestParam,null).compose(new ObjectTransform<AvatarUrl>()).subscribe(new Consumer<AvatarUrl>() {
            @Override
            public void accept(@NonNull AvatarUrl avatarUrl) throws Exception {
                getView().hideDialog();
                getView().showSucceed();
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();
                if (throwable instanceof NullPointerException)
                {
                    getView().showSucceed();
                }
            }
        });
    }

}

