package com.orientalfinance.eastcloud.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.orientalfinance.R;
import com.orientalfinance.databinding.FragmentChannelBinding;
import com.orientalfinance.eastcloud.adapter.ChannelPageAdapter;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.ChannelComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerChannelComponent;
import com.orientalfinance.eastcloud.dagger.modules.ChannelModules;
import com.orientalfinance.eastcloud.fragment.fragmentchannel.FragmentShangHai;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.ChannelCategory;
import com.orientalfinance.eastcloud.module.javabean.HomePageChannel;
import com.orientalfinance.eastcloud.mvp.View.ChannelView;
import com.orientalfinance.eastcloud.mvp.base.BaseFragment;
import com.orientalfinance.eastcloud.mvp.presenter.ChannelPresenter;
import com.orientalfinance.eastcloud.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentChannel#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentChannel extends BaseFragment<ChannelComponent, ChannelView, ChannelPresenter> implements ChannelView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FragmentChannelBinding mFragmentChannelBinding;
    private static String TAG = FragmentChannel.class.getSimpleName();

    public FragmentChannel() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_channel;
    }

    @Override
    protected ChannelComponent constructComponent(AppComponent appComponent) {
        return DaggerChannelComponent.builder().appComponent(appComponent).channelModules(new ChannelModules()).build();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentDashBoard.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentChannel newInstance(String param1, String param2) {
        FragmentChannel fragment = new FragmentChannel();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFragmentChannelBinding = (FragmentChannelBinding) mViewDataBinding;


        RequestParam requestParam = new RequestParam();
        getPresenter().showChannelCategory(requestParam);

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public void showChannelCategory(List<ChannelCategory> categories) {
        LogUtils.d(TAG, "showChannelCategory: " + categories.toString());
        mHomePageChannels = categories;
        List<String> tabTitle = new ArrayList<>();
        List<Fragment> mFragmentList = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            mFragmentList.add(FragmentShangHai.newInstance(categories.get(i).getCateId(), ""));
        }
        for (int i = 0; i < categories.size(); i++) {
            tabTitle.add(categories.get(i).getCateName());
        }
        mFragmentChannelBinding.vpChannel.setAdapter(new ChannelPageAdapter(getChildFragmentManager(), tabTitle, mFragmentList));
        mFragmentChannelBinding.tabChannel.setupWithViewPager(mFragmentChannelBinding.vpChannel);
        mFragmentChannelBinding.tabChannel.setTabMode(TabLayout.MODE_FIXED);
        if (categories.get(0)==null)
        {
            return;
        }
//        HomePageChannel.ShowChannelRequestParam showChannelRequestParam = new HomePageChannel.ShowChannelRequestParam(categories.get(0).getCateId());
//        RequestParam requestParam1 = new RequestParam(showChannelRequestParam);
//        getPresenter().showChannelList(requestParam1);
    }

    List<ChannelCategory> mHomePageChannels;

    @Override
    public void showChannelList(List<HomePageChannel> channels) {
        LogUtils.d(TAG, "showChannelList: "+channels.toString());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
}
