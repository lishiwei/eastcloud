package com.orientalfinance.eastcloud.fragment.fragmenthomepage;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.databinding.FragmentCurrentHitBinding;
import com.orientalfinance.eastcloud.adapter.CurrentHitRvAdpter;
import com.orientalfinance.eastcloud.adapter.LiveVideoRvAdapter;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.CurrentHitComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerCurrentHitComponent;
import com.orientalfinance.eastcloud.dagger.modules.CurrentHitModule;
import com.orientalfinance.eastcloud.dagger.qualifier.CurrentHit;
import com.orientalfinance.eastcloud.dagger.qualifier.LiveVideo;
import com.orientalfinance.eastcloud.module.javabean.Movie;
import com.orientalfinance.eastcloud.mvp.View.CurrentHitView;
import com.orientalfinance.eastcloud.mvp.View.FullyGridLayoutManager;
import com.orientalfinance.eastcloud.mvp.base.BaseFragment;
import com.orientalfinance.eastcloud.mvp.presenter.CurrentHitPresenter;
import com.orientalfinance.eastcloud.utils.GlideImageLoader;
import com.orientalfinance.eastcloud.utils.MyDataBindingUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCurrentHit#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCurrentHit extends BaseFragment<CurrentHitComponent, CurrentHitView, CurrentHitPresenter> implements CurrentHitView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FragmentCurrentHitBinding mFragmentCurrentHitBinding;
    @Inject
    List<String> mImageUrl;
    @Inject
    @CurrentHit
    CurrentHitRvAdpter mCurrentHitRvAdpter;
    @Inject
    @LiveVideo
    LiveVideoRvAdapter mLiveVideoRvAdapter;
    List<String> mStringList = new ArrayList<>();

    public FragmentCurrentHit() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCurrentHit.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCurrentHit newInstance(String param1, String param2) {
        FragmentCurrentHit fragment = new FragmentCurrentHit();
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
        return R.layout.fragment_current_hit;
    }

    @Override
    protected CurrentHitComponent constructComponent(AppComponent appComponent) {
        return DaggerCurrentHitComponent.builder().appComponent(appComponent).currentHitModule(new CurrentHitModule()).build();
    }

    @Override
    public void showView(List<Movie> movies) {
        mCurrentHitRvAdpter.setMovieList(movies);
        mLiveVideoRvAdapter.setMovieList(movies);
        mFragmentCurrentHitBinding.scrollview.setRefreshing(false);
    }

    @Override
    public void showDialog() {
        mFragmentCurrentHitBinding.scrollview.setRefreshing(true);
    }

    @Override
    public void hideDialog() {
        mFragmentCurrentHitBinding.scrollview.setRefreshing(false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mStringList.add("aaaaaaa");
        mStringList.add("bbbbbbbbbbbb");
        mStringList.add("cccccccccccccc");
        mStringList.add("dddddddddd");
        mFragmentCurrentHitBinding = (FragmentCurrentHitBinding) mViewDataBinding;
        mFragmentCurrentHitBinding.setUtils(new MyDataBindingUtils());
        mFragmentCurrentHitBinding.banner.setImageLoader(new GlideImageLoader());
        mFragmentCurrentHitBinding.banner.setImages(mImageUrl);
        mFragmentCurrentHitBinding.banner.start();
        mFragmentCurrentHitBinding.ryCurrentHit.setAdapter(mCurrentHitRvAdpter);
        mFragmentCurrentHitBinding.ryCurrentHit.setLayoutManager(new FullyGridLayoutManager(getActivity(), 3, LinearLayoutManager.VERTICAL, false));
        mFragmentCurrentHitBinding.rvLiveVideo.setAdapter(mLiveVideoRvAdapter);
        mFragmentCurrentHitBinding.rvLiveVideo.setLayoutManager(new FullyGridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false));
        mFragmentCurrentHitBinding.scrollview.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
//        mFragmentCurrentHitBinding.ryCurrentHit.setOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                int topRowVerticalPosition = (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
//                mFragmentCurrentHitBinding.scrollview.setEnabled(topRowVerticalPosition >= 0);
//            }
//        });

        mFragmentCurrentHitBinding.scrollview.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().start();
            }
        });
        getPresenter().start();
        mFragmentCurrentHitBinding.atvAdvertisement.setStringList(mStringList);
        mFragmentCurrentHitBinding.atvAdvertisement.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mFragmentCurrentHitBinding.atvAdvertisement.stop();
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(getContext(), errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        mFragmentCurrentHitBinding.atvAdvertisement.start();

    }
}
