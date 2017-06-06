package com.orientalfinance.eastcloud.fragment.fragmenthomepage;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.orientalfinance.R;
import com.orientalfinance.databinding.FragmentTvplayBinding;
import com.orientalfinance.eastcloud.adapter.TVPlayRvAdapter;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerTvPlayComponent;
import com.orientalfinance.eastcloud.dagger.component.TvPlayComponent;
import com.orientalfinance.eastcloud.dagger.modules.TVPlayModule;
import com.orientalfinance.eastcloud.mvp.View.FullyLinearLayoutManager;
import com.orientalfinance.eastcloud.mvp.View.TVPlayView;
import com.orientalfinance.eastcloud.mvp.base.BaseFragment;
import com.orientalfinance.eastcloud.mvp.presenter.TVPlayPresenter;
import com.orientalfinance.eastcloud.utils.DensityUtil;
import com.orientalfinance.eastcloud.utils.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTVPlay#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTVPlay extends BaseFragment<TvPlayComponent,TVPlayView,TVPlayPresenter>implements TVPlayView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

@Inject
    List<String>  mStringList;
@Inject
    TVPlayRvAdapter mTVPlayRvAdapter;
    FragmentTvplayBinding mFragmentTvplayBinding;
    public FragmentTVPlay() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTVPlay.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTVPlay newInstance(String param1, String param2) {
        FragmentTVPlay fragment = new FragmentTVPlay();
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
        mFragmentTvplayBinding = (FragmentTvplayBinding) mViewDataBinding;

        mFragmentTvplayBinding.rvPlay.setAdapter(mTVPlayRvAdapter);
mFragmentTvplayBinding.rvPlay.setLayoutManager(new FullyLinearLayoutManager(getActivity()));
        Banner banner= new Banner(getActivity());
        banner.setPadding(0,0,0, DensityUtil.dp2px(12));
        banner.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DensityUtil.dp2px(200)));
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(mStringList);
        banner.start();
mTVPlayRvAdapter.setHeaderView(banner);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tvplay;
    }

    @Override
    protected TvPlayComponent constructComponent(AppComponent appComponent) {
        return DaggerTvPlayComponent.builder().appComponent(appComponent).tVPlayModule(new TVPlayModule()).build();
    }

}
