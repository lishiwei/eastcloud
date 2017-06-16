package com.orientalfinance.eastcloud.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mcxtzhang.swipemenulib.SwipeMenuLayout;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.adapter.CollectionAdapter;
import com.orientalfinance.eastcloud.module.Retrofit.DeleteRequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.ShowRequestParam;
import com.orientalfinance.eastcloud.module.javabean.Channel;
import com.orientalfinance.eastcloud.mvp.View.ActivityMyCollectionView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityMyCollectionPresenter;
import com.orientalfinance.eastcloud.view.OnSwipeDeleteListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lzy on 2017/6/15.
 * email:lizy@oriental-finance.com
 */

public class ActivityMyCollection extends BaseMVPActivity<ActivityMyCollectionView, ActivityMyCollectionPresenter>
        implements AdapterView.OnItemClickListener, View.OnClickListener, ActivityMyCollectionView {

    private static final String TAG = "zxt";
    private ListView mLv;

    private ArrayList<Channel> mChannels = new ArrayList<>();
    private CollectionAdapter collectionAdapter;
    private TextView editButton;
    private Button selectAll;
    private Button invertSelection;
    private LinearLayout title_ll;
    private boolean listViewState = true;//当前界面状态,初始进入为ListView，即非编辑的状态,设为true
    String mDeleteId;

    @NonNull
    @Override
    public ActivityMyCollectionPresenter createPresenter() {
        return new ActivityMyCollectionPresenter();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);

        collectionAdapter = new CollectionAdapter(this, mChannels);
        findViews();
        mLv.setAdapter(collectionAdapter);
        mLv.setOnItemClickListener(this);
        ShowRequestParam showRequestParam = new ShowRequestParam(0, 10);
        RequestParam requestParam = new RequestParam(showRequestParam);
        getPresenter().showCollection(requestParam);
    }


    private void findViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        editButton = (TextView) findViewById(R.id.btn_del);
        selectAll = (Button) findViewById(R.id.select_all_btn);
        invertSelection = (Button) findViewById(R.id.disselected_all_btn);
        title_ll = (LinearLayout) findViewById(R.id.title_ll);


        editButton.setOnClickListener(this);
        selectAll.setOnClickListener(this);
        invertSelection.setOnClickListener(this);

        mLv = (ListView) findViewById(R.id.test);
        collectionAdapter.setOnSwipeDeleteListener(new OnSwipeDeleteListener() {
            @Override
            public void onDeleteListener(SwipeMenuLayout swipeMenuLayout, int position) {
                mDeleteId = mChannels.get(position).getId();
                DeleteRequestParam deleteRequestParam = new DeleteRequestParam(mDeleteId);
                getPresenter().deleteCollection(new RequestParam(deleteRequestParam));
            }
        });
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Channel channel = mChannels.get(position);
        channel.setChecked(!channel.isChecked());
        collectionAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_del:
                /**
                 * 此为控制编辑状态的Button,需要根据当前页面状态来改变状态,
                 * 因为要实现控制ChekBox是否显示,而CheckBox只能从适配器中获取到，
                 * 所以通过在CustomAdapter中设置一个标记,在此处调用CustomAdapter中的方法改变该标记,
                 * 同时通知CustomAdapter数据发生了改变,强制调用getView去刷新界面
                 *
                 */
                boolean isShow = collectionAdapter.isShow();//从适配器里面查看当前页面状态
                collectionAdapter.setShow(!isShow);//点击以后改变CustomAdapter中的标记
                collectionAdapter.notifyDataSetChanged();//通知适配器数据更新了,改变界面

                if (listViewState) {
                    changeState2Edit();
                } else {
                    deleteSelectedData();//标记状态下点击该Button要删除选中的数据
                    changeState2Normal();
                }
                break;

            case R.id.select_all_btn:
                selectAllData();
                break;

            case R.id.disselected_all_btn:
                disSelectedAllData();
                break;
        }
    }

    /**
     * 反选
     */
    private void disSelectedAllData() {
        for (Channel tvShowEntity : mChannels) {
            tvShowEntity.setChecked(!tvShowEntity.isChecked());
        }
        collectionAdapter.notifyDataSetChanged();
    }

    /**
     * 全选
     */
    private void selectAllData() {
        for (Channel tvShowEntity : mChannels) {
            tvShowEntity.setChecked(true);
        }
        collectionAdapter.notifyDataSetChanged();
    }

    /**
     * 删除所选
     */
    private void deleteSelectedData() {
        Iterator<Channel> it = mChannels.iterator();
        while (it.hasNext()) {
            Channel tvShowEntity = it.next();
            if (tvShowEntity.isChecked()) {
                it.remove();
            }
        }
    }

    /**
     * 将页面状态改变为非编辑状态
     */
    private void changeState2Normal() {
        editButton.setText("编辑");
        title_ll.setVisibility(View.GONE);
        listViewState = true;
    }

    /**
     * 将页面状态改变为编辑状态
     */
    private void changeState2Edit() {
        editButton.setText("删除");
        title_ll.setVisibility(View.VISIBLE);
        listViewState = false;
    }

    @Override
    public void showDialog() {
        mEastCloudDialog.show();
    }

    @Override
    public void hideDialog() {
        mEastCloudDialog.hide();
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCollection(List<Channel> channels) {
        collectionAdapter.setData(channels);
    }


    @Override
    public void deleteSucceed(int id) {
        Toast.makeText(this, "删除成功!", Toast.LENGTH_SHORT).show();

    }
}
