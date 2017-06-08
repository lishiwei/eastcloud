package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.javabean.Detail;
import com.orientalfinance.eastcloud.mvp.View.TVPlayDetailView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import javax.inject.Inject;

/**
 * Created by 29435 on 2017/5/26.
 */

public class TVPlayDetailPresenter extends MvpNullObjectBasePresenter<TVPlayDetailView>{
    Detail mDetail;
    @Inject
    public TVPlayDetailPresenter(Detail detail) {
        mDetail = detail;
    }
    public void start()
    {
        getView().showView(mDetail);
    }
}
