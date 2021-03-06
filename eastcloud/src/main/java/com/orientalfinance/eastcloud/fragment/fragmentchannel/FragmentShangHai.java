package com.orientalfinance.eastcloud.fragment.fragmentchannel;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;

import com.orientalfinance.R;
import com.orientalfinance.databinding.FragmentShangHaiBinding;
import com.orientalfinance.eastcloud.adapter.ChannelRvAdapter;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerShangHaiComponent;
import com.orientalfinance.eastcloud.dagger.component.ShangHaiComponent;
import com.orientalfinance.eastcloud.dagger.modules.ShangHaiModules;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.HomePageChannel;
import com.orientalfinance.eastcloud.mvp.View.FullyLinearLayoutManager;
import com.orientalfinance.eastcloud.mvp.View.ShangHaiView;
import com.orientalfinance.eastcloud.mvp.base.BaseFragment;
import com.orientalfinance.eastcloud.mvp.presenter.ShangHaiPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentShangHai#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentShangHai extends BaseFragment<ShangHaiComponent, ShangHaiView, ShangHaiPresenter> implements ShangHaiView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentShangHai() {
        // Required empty public constructor
    }

    FragmentShangHaiBinding mFragmentShangHaiBinding;
    @Inject
    ChannelRvAdapter mChannelRvAdapter;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentShangHai.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentShangHai newInstance(String param1, String param2) {
        FragmentShangHai fragment = new FragmentShangHai();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFragmentShangHaiBinding = (FragmentShangHaiBinding) mViewDataBinding;
        mFragmentShangHaiBinding.rvShanghai.setLayoutManager(new FullyLinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        HomePageChannel.ShowChannelRequestParam showChannelRequestParam = new HomePageChannel.ShowChannelRequestParam(mParam1);
        RequestParam requestParam1 = new RequestParam(showChannelRequestParam);
        getPresenter().showChannelList(requestParam1);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shang_hai;
    }

    @Override
    protected ShangHaiComponent constructComponent(AppComponent appComponent) {
        return DaggerShangHaiComponent.builder().appComponent(appComponent).shangHaiModules(new ShangHaiModules()).build();
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
    public void showChannelList(List<HomePageChannel> homePageChannels) {
//        mChannelRvAdapter
        mFragmentShangHaiBinding.rvShanghai.setAdapter(mChannelRvAdapter);

    }
}
