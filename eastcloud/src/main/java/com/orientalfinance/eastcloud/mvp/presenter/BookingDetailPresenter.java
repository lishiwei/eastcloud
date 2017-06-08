package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.javabean.Detail;
import com.orientalfinance.eastcloud.mvp.View.BookingDetailView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import javax.inject.Inject;

/**
 * Created by 29435 on 2017/5/25.
 */

public class BookingDetailPresenter extends MvpNullObjectBasePresenter<BookingDetailView> {
    Detail mDetail;
@Inject
    public BookingDetailPresenter(Detail detail) {
    mDetail = detail;
    }

    @Override
    public void attachView(BookingDetailView view) {
        super.attachView(view);

    }

    public void start()
    {
        getView().showLoading();

        getView().showView(mDetail);
    }
    @Override
    public void detachView(boolean retainInstance) {

    }
}
