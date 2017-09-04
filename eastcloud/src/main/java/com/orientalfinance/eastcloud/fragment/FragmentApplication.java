package com.orientalfinance.eastcloud.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.orientalfinance.R;
import com.orientalfinance.databinding.FragmentApplicationBinding;
import com.orientalfinance.eastcloud.adapter.HotApplicationRvAdapter;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.ApplicationComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerApplicationComponent;
import com.orientalfinance.eastcloud.dagger.modules.ApplicationModule;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Application;
import com.orientalfinance.eastcloud.module.javabean.Banner;
import com.orientalfinance.eastcloud.mvp.View.ApplicationView;
import com.orientalfinance.eastcloud.mvp.View.FullyLinearLayoutManager;
import com.orientalfinance.eastcloud.mvp.base.BaseFragment;
import com.orientalfinance.eastcloud.mvp.presenter.ApplicationPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentApplication#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentApplication extends BaseFragment<ApplicationComponent, ApplicationView, ApplicationPresenter> implements ApplicationView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //
    @Inject
    HotApplicationRvAdapter mHotApplicationRvAdapter;
    FragmentApplicationBinding mFragmentApplicationBinding;

    List<String> mImageUrl = new ArrayList<>();
    public FragmentApplication() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentApplication.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentApplication newInstance(String param1, String param2) {
        FragmentApplication fragment = new FragmentApplication();
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
        mFragmentApplicationBinding = (FragmentApplicationBinding) mViewDataBinding;

        mFragmentApplicationBinding.rvHotApplication.setAdapter(mHotApplicationRvAdapter);
mImageUrl.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg");
mImageUrl.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg");
mImageUrl.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789067895&di=d9384b70b7a09110f641283579a68059&imgtype=0&src=http%3A%2F%2Fhimg2.huanqiu.com%2Fattachment2010%2F2016%2F1221%2F20161221024159122.jpg");
        mHotApplicationRvAdapter.setImageUrl(mImageUrl);
        mFragmentApplicationBinding.rvHotApplication.setLayoutManager(new FullyLinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mFragmentApplicationBinding.refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getApplicationBanner();
                getApplicationList();
            }
        });
//        mFragmentApplicationBinding.rvAllApplication.setAdapter(mHotApplicationRvAdapter);
//        mFragmentApplicationBinding.rvAllApplication.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
//        mFragmentApplicationBinding.rvMyApplication.setAdapter(mHotApplicationRvAdapter);
//        mFragmentApplicationBinding.rvMyApplication.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
    }

    public void getApplicationList() {
        RequestParam requestParam = new RequestParam();
        getPresenter().getApplicationList(requestParam);
    }

    public void getApplicationBanner() {
        RequestParam requestParam = new RequestParam();
        getPresenter().getApplicationBanner(requestParam);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_application;
    }

    @Override
    protected ApplicationComponent constructComponent(AppComponent appComponent) {
        return DaggerApplicationComponent.builder().appComponent(appComponent).applicationModule(new ApplicationModule()).build();
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String errorMsg) {
        stopRefresh();
    }

    @Override
    public void showAppList(List<Application> applications) {
//        items = applications;

//        MultiTypeAdapter multiTypeAdapter = new MultiTypeAdapter();
//        multiTypeAdapter.setItems(items);
        stopRefresh();
    }

    public void stopRefresh() {
        if (mFragmentApplicationBinding.refresh != null && mFragmentApplicationBinding.refresh.isRefreshing()) {
            mFragmentApplicationBinding.refresh.setRefreshing(false);
        }
    }

    @Override
    public void showAppBanner(List<Banner> banners) {

        mImageUrl.clear();
        for (int i = 0; i < banners.size(); i++) {
            mImageUrl.add(banners.get(i).getBannerImage());
        }

        mHotApplicationRvAdapter.setImageUrl(mImageUrl);
//        mFragmentApplicationBinding.banner.setImages(mImageUrl);
//        mFragmentApplicationBinding.banner.start();
        stopRefresh();
    }
}
