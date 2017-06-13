package com.orientalfinance.eastcloud.mvp.presenter;


import android.util.Log;
import android.widget.Toast;

import com.orientalfinance.eastcloud.App;
import com.orientalfinance.eastcloud.module.Retrofit.EastcloudRetrofit;
import com.orientalfinance.eastcloud.module.Retrofit.HttpCallBack;
import com.orientalfinance.eastcloud.module.Retrofit.MyTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.core.CommonRequestParam;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.RegistView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ActivityRegistPresenter extends MvpNullObjectBasePresenter<RegistView> {
    private static final String TAG = ActivityRegistPresenter.class.getSimpleName();

    @Override
    public void attachView(RegistView view) {

    }

    @Override
    public void detachView(boolean retainInstance) {

    }

    public void codeSend() {
        getView().showRegist();

    }

    public void start() {


    }
}
