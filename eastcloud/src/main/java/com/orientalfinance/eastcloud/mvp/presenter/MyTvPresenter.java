package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.mvp.View.MyTVView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import javax.inject.Inject;

/**
 * Created by 29435 on 2017/5/26.
 */

public class MyTvPresenter extends MvpNullObjectBasePresenter<MyTVView> {
    private static final String TAG = MyTvPresenter.class.getSimpleName();
@Inject
    public MyTvPresenter() {
    }

    @Override
    public void attachView(MyTVView view) {

    }

    @Override
    public void detachView(boolean retainInstance) {

    }



    public void start() {


    }
}
