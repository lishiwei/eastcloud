package com.orientalfinance.eastcloud.mvp.presenter;

import android.util.Log;

import com.orientalfinance.eastcloud.module.javabean.Detail;
import com.orientalfinance.eastcloud.mvp.View.ActivityDetailView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import javax.inject.Inject;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ActivityDetailPresenter extends MvpNullObjectBasePresenter<ActivityDetailView> {
    private static final String TAG = ActivityDetailPresenter.class.getSimpleName();
    Detail mDetail;

    @Inject
    public ActivityDetailPresenter(Detail detail) {
        mDetail = detail;
    }

    public void start() {
        Log.d(TAG, "start: "+mDetail.toString());
        getView().showView(mDetail);

    }
}
