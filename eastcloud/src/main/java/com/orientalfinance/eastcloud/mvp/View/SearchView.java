package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.orientalfinance.eastcloud.module.Detail;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface SearchView extends MvpView{

    public void showView(Detail detail);
    public void showLoading();
    public void hideLoading();
}
