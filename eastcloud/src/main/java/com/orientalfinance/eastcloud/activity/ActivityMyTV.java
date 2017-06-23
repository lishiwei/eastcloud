package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityMyTvBinding;
import com.orientalfinance.eastcloud.adapter.MyTVRvAdpter;
import com.orientalfinance.eastcloud.dagger.component.ActivityMyTVComponent;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerActivityMyTVComponent;
import com.orientalfinance.eastcloud.dagger.modules.ActivityMyTVModule;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.ShowRequestParam;
import com.orientalfinance.eastcloud.module.javabean.TV;
import com.orientalfinance.eastcloud.mvp.View.FullyLinearLayoutManager;
import com.orientalfinance.eastcloud.mvp.View.MyTVView;
import com.orientalfinance.eastcloud.mvp.View.MyTVViewViewState;
import com.orientalfinance.eastcloud.mvp.base.BaseActivity;
import com.orientalfinance.eastcloud.mvp.presenter.MyTvPresenter;
import com.orientalfinance.eastcloud.view.OnItemClickListener;

import java.util.List;

import javax.inject.Inject;

public class ActivityMyTV extends BaseActivity<ActivityMyTVComponent, MyTVView, MyTvPresenter, MyTVViewViewState> implements MyTVView {
    @Inject
    MyTVRvAdpter mMyTVRvAdpter;
    ActivityMyTvBinding mActivityMyTvBinding;

    int mPosition;

    @Override
    public void showDelectTVBox() {
        mEastCloudProgressDialog.setTitle("删除中...");
        mEastCloudProgressDialog.show();
    }

    @Override
    public void delectSucceed() {
        mMyTVRvAdpter.removeItem(mPosition);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMyTvBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mActivityMyTvBinding.rvMyTV.setAdapter(mMyTVRvAdpter);
        mActivityMyTvBinding.rvMyTV.setLayoutManager(new FullyLinearLayoutManager(this));

        mActivityMyTvBinding.rvMyTV.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onDeleteClick(int position) {
                mPosition = position;
                TV.DelTVRequestParam delTVRequestParam = new TV.DelTVRequestParam(mMyTVRvAdpter.getMovieList().get(position).getId());
                getPresenter().delTVBox(new RequestParam<TV.DelTVRequestParam>(delTVRequestParam));

            }
        });
        ShowRequestParam requestParam = new ShowRequestParam(0, 10);
        getPresenter().showTVBox(new RequestParam<>(requestParam));

        mActivityMyTvBinding.toolbar.setTitle("");
        setSupportActionBar(mActivityMyTvBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        mEastCloudProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        mEastCloudProgressDialog.hide();
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    protected ActivityMyTVComponent constructComponent(AppComponent appComponent) {
        return DaggerActivityMyTVComponent.builder().appComponent(appComponent).activityMyTVModule(new ActivityMyTVModule()).build();
    }

}
