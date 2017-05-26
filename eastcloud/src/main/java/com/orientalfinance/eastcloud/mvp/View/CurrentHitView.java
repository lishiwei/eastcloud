package com.orientalfinance.eastcloud.mvp.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface CurrentHitView extends MvpView{

     class CurrentHitViewState implements ViewState<CurrentHitView>{
         @Override
         public void apply(CurrentHitView view, boolean retained) {

         }
     }
}
