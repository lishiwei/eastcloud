package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.orientalfinance.eastcloud.module.javabean.Detail;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface DetailView extends MvpView{

    void showView(Detail detail);
    void showLoading();
    void hideLoading();
}
