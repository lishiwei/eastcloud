package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.orientalfinance.eastcloud.module.Detail;
import com.orientalfinance.eastcloud.module.Movie;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface ActivityLoginView extends MvpView{


    public void showLogin();
    public void showError();
public void setUser(Movie movie);

}
