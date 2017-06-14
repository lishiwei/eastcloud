package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityMyTvBinding;
import com.orientalfinance.eastcloud.adapter.MyTVRvAdpter;
import com.orientalfinance.eastcloud.dagger.component.ActivityMyTVComponent;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerActivityMyTVComponent;
import com.orientalfinance.eastcloud.dagger.modules.ActivityMyTVModule;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.TV;
import com.orientalfinance.eastcloud.mvp.View.FullyLinearLayoutManager;
import com.orientalfinance.eastcloud.mvp.View.MyTVView;
import com.orientalfinance.eastcloud.mvp.View.MyTVViewViewState;
import com.orientalfinance.eastcloud.mvp.base.BaseActivity;
import com.orientalfinance.eastcloud.mvp.presenter.MyTvPresenter;

import java.util.List;

import javax.inject.Inject;

public class ActivityMyTV extends BaseActivity<ActivityMyTVComponent, MyTVView, MyTvPresenter, MyTVViewViewState> implements MyTVView {
    @Inject
    MyTVRvAdpter mMyTVRvAdpter;
    ActivityMyTvBinding mActivityMyTvBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMyTvBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mActivityMyTvBinding.rvMyTV.setAdapter(mMyTVRvAdpter);
        mActivityMyTvBinding.rvMyTV.setLayoutManager(new FullyLinearLayoutManager(this));
//        TV.ShowTVRequestParam requestParam = new TV.ShowTVRequestParam(0, 10);
//        getPresenter().showTVBox(new RequestParam<TV.ShowTVRequestParam>(requestParam));

//
//        TV.DelTVRequestParam delTVRequestParam = new TV.DelTVRequestParam("12");
//        getPresenter().delTVBox(new RequestParam<TV.DelTVRequestParam>(delTVRequestParam));

        TV.ScanTVRequestParam scanTVRequestParam = new TV.ScanTVRequestParam("5");
        getPresenter().scanTVBox(new RequestParam<TV.ScanTVRequestParam>(scanTVRequestParam));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_tv;
    }

    @Override
    public boolean hasToolBar() {
        return false;
    }

    @Override
    public String getToolBarTitle() {
        return null;
    }

    @Override
    public void showTVBox(List<TV> list) {
        mMyTVRvAdpter.setMovieList(list);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    protected ActivityMyTVComponent constructComponent(AppComponent appComponent) {
        return DaggerActivityMyTVComponent.builder().appComponent(appComponent).activityMyTVModule(new ActivityMyTVModule()).build();
    }
}
