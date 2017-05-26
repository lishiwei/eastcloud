package com.orientalfinance.eastcloud.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orientalfinance.R;

import com.orientalfinance.databinding.FragmentApplicationBinding;
import com.orientalfinance.eastcloud.adapter.HotApplicationRvAdapter;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.ApplicationComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerApplicationComponent;
import com.orientalfinance.eastcloud.dagger.modules.ApplicationModule;
import com.orientalfinance.eastcloud.mvp.View.ApplicationView;
import com.orientalfinance.eastcloud.mvp.base.BaseFragment;
import com.orientalfinance.eastcloud.mvp.presenter.ApplicationPresenter;
import com.orientalfinance.eastcloud.mvp.presenter.HomePagePresenter;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentApplication#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentApplication extends BaseFragment<ApplicationComponent,ApplicationView,ApplicationPresenter>implements ApplicationView {
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
        mFragmentApplicationBinding.rvHotApplication.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,true));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_application;
    }

    @Override
    protected ApplicationComponent constructComponent(AppComponent appComponent) {
        return DaggerApplicationComponent.builder().appComponent(appComponent).applicationModule(new ApplicationModule()).build();
    }


}
