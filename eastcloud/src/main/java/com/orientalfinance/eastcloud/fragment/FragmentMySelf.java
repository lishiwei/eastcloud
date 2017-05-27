package com.orientalfinance.eastcloud.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.orientalfinance.R;
import com.orientalfinance.databinding.FragmentMySelfBinding;
import com.orientalfinance.eastcloud.adapter.RVAdapter;

import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerMyselfComponent;
import com.orientalfinance.eastcloud.dagger.component.MyselfComponent;
import com.orientalfinance.eastcloud.dagger.modules.MyselfModule;
import com.orientalfinance.eastcloud.mvp.View.FullyGridLayoutManager;
import com.orientalfinance.eastcloud.mvp.View.MyselfView;
import com.orientalfinance.eastcloud.mvp.base.BaseFragment;
import com.orientalfinance.eastcloud.mvp.presenter.MyselfPresenter;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link FragmentMySelf#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMySelf extends BaseFragment<MyselfComponent, MyselfView, MyselfPresenter> implements MyselfView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @Inject
    RVAdapter mMyselfRvAdapter;

    FragmentMySelfBinding mFragmentMySelfBinding;

    public FragmentMySelf() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMySelf.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMySelf newInstance(String param1, String param2) {
        FragmentMySelf fragment = new FragmentMySelf();
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
    protected int getLayoutId() {
        return R.layout.fragment_my_self;
    }

    @Override
    protected MyselfComponent constructComponent(AppComponent appComponent) {
        return DaggerMyselfComponent.builder().appComponent(appComponent).myselfModule(new MyselfModule()).build();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFragmentMySelfBinding = (FragmentMySelfBinding) mViewDataBinding;
        mFragmentMySelfBinding.setAvatarUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495868225264&di=adafe75c2dcda203bded7c4acd72cb25&imgtype=0&src=http%3A%2F%2Fnpic7.fangtoo.com%2Fcn%2Fzixun%2Fzh-chs%2F2017-04%2F17%2F126105-30_170417115300_1_lit.jpg");
        mFragmentMySelfBinding.rvMyself.setAdapter(mMyselfRvAdapter);
        mFragmentMySelfBinding.rvMyself.setLayoutManager(new FullyGridLayoutManager(getActivity(), 4, LinearLayoutManager.VERTICAL, true));
    }
}
