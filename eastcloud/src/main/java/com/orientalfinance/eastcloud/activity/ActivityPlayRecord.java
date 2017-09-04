package com.orientalfinance.eastcloud.activity;

import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mcxtzhang.swipemenulib.SwipeMenuLayout;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityPlayRecordBinding;
import com.orientalfinance.eastcloud.adapter.PlayRecordRvAdpter;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerPlayRecordComponent;
import com.orientalfinance.eastcloud.dagger.component.PlayRecordComponent;
import com.orientalfinance.eastcloud.dagger.modules.PlayRecordModule;
import com.orientalfinance.eastcloud.module.Retrofit.DeleteRequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.ShowRequestParam;
import com.orientalfinance.eastcloud.module.javabean.History;
import com.orientalfinance.eastcloud.mvp.View.FullyLinearLayoutManager;
import com.orientalfinance.eastcloud.mvp.View.PlayRecordView;
import com.orientalfinance.eastcloud.mvp.View.PlayRecordViewState;
import com.orientalfinance.eastcloud.mvp.base.BaseActivity;
import com.orientalfinance.eastcloud.mvp.presenter.PlayRecordPresenter;
import com.orientalfinance.eastcloud.view.MainGuideDialog;
import com.orientalfinance.eastcloud.view.OnSwipeDeleteListener;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

public class ActivityPlayRecord extends BaseActivity<PlayRecordComponent, PlayRecordView, PlayRecordPresenter, PlayRecordViewState> implements PlayRecordView {
    private static final java.lang.String TAG = ActivityPlayRecord.class.getSimpleName();
    @Inject
    PlayRecordRvAdpter mPlayRecordRvAdpter;
    ActivityPlayRecordBinding mActivityPlayRecordBinding;
    MenuItem mMenuItem;
    int mDeletePosition;

    @Override
    public boolean hasToolBar() {
        return false;
    }

    @Override
    public String getToolBarTitle() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityPlayRecordBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mActivityPlayRecordBinding.toolbar.setTitle("");

        setSupportActionBar(mActivityPlayRecordBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mPlayRecordRvAdpter.setOnSwipeDeleteListener(new OnSwipeDeleteListener() {
            @Override
            public void onDeleteListener(SwipeMenuLayout swipeMenuLayout, int position) {
                mDeletePosition = position;
                getPresenter().deleteHistory(new RequestParam(new DeleteRequestParam(mPlayRecordRvAdpter.getChannelList().get(position).getId())));

            }
        });
        mActivityPlayRecordBinding.rvHistory.setLayoutManager(new FullyLinearLayoutManager(this));
        mActivityPlayRecordBinding.rvHistory.setAdapter(mPlayRecordRvAdpter);

        ShowRequestParam showRequestParam = new ShowRequestParam(0, 10);
        RequestParam requestParam = new RequestParam(showRequestParam);
        getPresenter().showHistory(requestParam);
        initView();
    }

    private void initView() {
        mActivityPlayRecordBinding.btnSelectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (History channel : mPlayRecordRvAdpter.getChannelList()) {
                    channel.setChecked(true);
                }
                mPlayRecordRvAdpter.notifyDataSetChanged();
            }
        });
        mActivityPlayRecordBinding.btnDisSelectedAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (History channel : mPlayRecordRvAdpter.getChannelList()) {
                    channel.setChecked(!channel.isChecked());
                }
                mPlayRecordRvAdpter.notifyDataSetChanged();
            }
        });

        mMainGuideDialog = new MainGuideDialog.Builder(this).setTitle("提示").setMessage("清空观看历史？").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                DeleteRequestParam deleteRequestParam = new DeleteRequestParam();
                getPresenter().deleteHistory(new RequestParam(deleteRequestParam));

            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_play_record;
    }

    @Override
    protected PlayRecordComponent constructComponent(AppComponent appComponent) {
        return DaggerPlayRecordComponent.builder().appComponent(appComponent).playRecordModule(new PlayRecordModule()).build();
    }

    @Override
    public void showDialog() {
        mEastCloudProgressDialog.show();
    }

    @Override
    public void hideDialog() {
        mEastCloudProgressDialog.hide();
    }

    @Override
    public void showHistory(List<History> channels) {

        mPlayRecordRvAdpter.setChannelList(channels);
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manage, menu);
        return true;
    }

    private boolean isEditableState = true;//当前界面状态,初始进入为ListView，即非编辑的状态,true
    MainGuideDialog mMainGuideDialog;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.manage) {

            if (!mMainGuideDialog.isShowing()) {
                mMainGuideDialog.show();
            }
//            mMenuItem = item;
//            item.setTitle("删除");
//            boolean isShow = mPlayRecordRvAdpter.isShow();
//            mPlayRecordRvAdpter.setShow(!isShow);
//            LogUtils.d(TAG, "onOptionsItemSelected: " + mPlayRecordRvAdpter.isShow);
//            mPlayRecordRvAdpter.notifyDataSetChanged();
//            if (isEditableState) {
//                changeState2Edit();
//            } else {
//                deleteSelectedData();
//                changeState2Normal();
//            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void deleteSelectedData() {
        Iterator<History> it = mPlayRecordRvAdpter.getChannelList().iterator();
        while (it.hasNext()) {
            History channel = it.next();
            if (channel.isChecked()) {
                it.remove();
            }
        }
    }

    @Override
    public void deleteSucceed(int position) {
        mPlayRecordRvAdpter.getChannelList().remove(mDeletePosition);
        mPlayRecordRvAdpter.notifyDataSetChanged();
    }

    @Override
    public void deleteFailed(int id) {
        if (id == -1) {
            mPlayRecordRvAdpter.getChannelList().clear();
            mPlayRecordRvAdpter.notifyDataSetChanged();
        } else {
            mPlayRecordRvAdpter.getChannelList().remove(mDeletePosition);
            mPlayRecordRvAdpter.notifyDataSetChanged();
        }
        Toast.makeText(this, "删除失败!", Toast.LENGTH_SHORT).show();
    }

    /**
     * 将页面状态改变为非编辑状态
     */
    private void changeState2Normal() {
        mMenuItem.setTitle("编辑");
        mActivityPlayRecordBinding.titleLl.setVisibility(View.GONE);
        isEditableState = true;
    }

    /**
     * 将页面状态改变为编辑状态
     */
    private void changeState2Edit() {
        mMenuItem.setTitle("删除");
        mActivityPlayRecordBinding.titleLl.setVisibility(View.VISIBLE);
        isEditableState = false;
    }
}
