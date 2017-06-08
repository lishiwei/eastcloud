package com.orientalfinance.eastcloud.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.orientalfinance.R;
import com.orientalfinance.databinding.FragmentHomePageBinding;
import com.orientalfinance.eastcloud.adapter.CurrentHitPageAdapter;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerHomePageComponent;
import com.orientalfinance.eastcloud.dagger.component.HomePageComponent;
import com.orientalfinance.eastcloud.mvp.View.HomepageView;
import com.orientalfinance.eastcloud.mvp.base.BaseFragment;
import com.orientalfinance.eastcloud.mvp.presenter.HomePagePresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHomePage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHomePage extends BaseFragment<HomePageComponent, HomepageView, HomePagePresenter> implements HomepageView {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected HomePageComponent constructComponent(AppComponent appComponent) {
        return DaggerHomePageComponent.builder().appComponent(appComponent).build();
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FragmentHomePageBinding mFragmentHomePageBinding;

    @Inject
    List<String> mImageUrl;

    public FragmentHomePage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHomePage.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHomePage newInstance(String param1, String param2) {
        FragmentHomePage fragment = new FragmentHomePage();
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
        mFragmentHomePageBinding = (FragmentHomePageBinding) mViewDataBinding;
        mFragmentHomePageBinding.vpHomePage.setAdapter(new CurrentHitPageAdapter(getChildFragmentManager()));
        mFragmentHomePageBinding.tabHomepage.setTabMode(TabLayout.MODE_FIXED);
        mFragmentHomePageBinding.tabHomepage.setupWithViewPager(mFragmentHomePageBinding.vpHomePage);
    }


}
