package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.mvp.View.CurrentHitView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import javax.inject.Inject;

/**
 * Created by 29435 on 2017/5/26.
 */

public class CurrentHitPresenter extends MvpNullObjectBasePresenter<CurrentHitView>{
    @Inject
    public CurrentHitPresenter() {
    }

    @Override
    public void attachView(CurrentHitView view) {
        super.attachView(view);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }

}
