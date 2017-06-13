package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.mvp.View.RegistView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

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
