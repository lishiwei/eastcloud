package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.Movie;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface CurrentHitView extends BaseMvpView{

    public void showView(List<Movie> movies);

}
