package com.orientalfinance.eastcloud.fragment.fragmenthomepage;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.Advertisement;
import com.orientalfinance.eastcloud.module.javabean.Banner;
import com.orientalfinance.eastcloud.module.javabean.HomePageChannel;
import com.orientalfinance.eastcloud.module.javabean.HomepageProgram;
import com.orientalfinance.eastcloud.module.javabean.Program;
import com.orientalfinance.eastcloud.mvp.View.CurrentHitView;
import com.orientalfinance.eastcloud.mvp.View.FullyGridLayoutManager;
import com.orientalfinance.eastcloud.mvp.base.BaseFragment;
import com.orientalfinance.eastcloud.mvp.presenter.CurrentHitPresenter;
import com.orientalfinance.eastcloud.utils.GlideImageLoader;
import com.orientalfinance.eastcloud.utils.MyDataBindingUtils;

import java.util.ArrayList;
import java.util.List;

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
    List<String> mImageUrl;

    CurrentHitRvAdpter mCurrentHitRvAdpter ;

    LiveVideoRvAdapter mLiveVideoRvAdapter;
    List<String> mAdverStringList = new ArrayList<>();
List<HomepageProgram> mCurrentHitPrograms = new ArrayList<>();
List<HomepageProgram> mLiveVideoPrograms = new ArrayList<>();
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
        mAdverStringList.add("aaaaaaa");
        mAdverStringList.add("bbbbbbbbbbbb");
        mAdverStringList.add("cccccccccccccc");
        mAdverStringList.add("dddddddddd");
        mCurrentHitRvAdpter = new CurrentHitRvAdpter(mCurrentHitPrograms );
        mLiveVideoRvAdapter = new LiveVideoRvAdapter(mLiveVideoPrograms );

        mImageUrl = new ArrayList<>();
        mFragmentCurrentHitBinding = (FragmentCurrentHitBinding) mViewDataBinding;
        mFragmentCurrentHitBinding.setUtils(new MyDataBindingUtils());
        mFragmentCurrentHitBinding.banner.setImageLoader(new GlideImageLoader());

        mFragmentCurrentHitBinding.ryCurrentHit.setAdapter(mCurrentHitRvAdpter);
        mFragmentCurrentHitBinding.ryCurrentHit.setLayoutManager(new FullyGridLayoutManager(getActivity(), 3, LinearLayoutManager.VERTICAL, false));
        mFragmentCurrentHitBinding.rvLiveVideo.setAdapter(mLiveVideoRvAdapter);
        mFragmentCurrentHitBinding.rvLiveVideo.setLayoutManager(new FullyGridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false));
        mFragmentCurrentHitBinding.scrollview.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light,
                android.R.color.holo_green_light);


        mFragmentCurrentHitBinding.atvAdvertisement.setStringList(mAdverStringList);
        mFragmentCurrentHitBinding.atvAdvertisement.start();
        getBanner();

        getAd();
        getCurrentHit();
        getProgramList();
    }


    private void getBanner() {
        RequestParam requestParam = new RequestParam();
        getPresenter().showBanner(requestParam);
    }

    private void getAd() {
        RequestParam requestParam = new RequestParam();
        getPresenter().showAdvertisement(requestParam);
    }

    private void getCurrentHit() {
        RequestParam requestParam = new RequestParam(new Program.CurrentHitRequestParam(1, 6,"1"));
        getPresenter().showCurrentHit(new RequestParam(requestParam));
    }

    private void getProgramList() {
        HomePageChannel.ShowChannelRequestParam requestParam = new HomePageChannel.ShowChannelRequestParam("" + 0);
        RequestParam requestParam1 = new RequestParam(requestParam);
        getPresenter().showProgramList(requestParam1);
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

    @Override
    public void showBanner(List<Banner> banners) {
        mImageUrl.clear();
        for (int i = 0; i < banners.size(); i++) {
            mImageUrl.add(banners.get(i).getBannerImage());
        }
        mFragmentCurrentHitBinding.banner.setImages(mImageUrl);
        mFragmentCurrentHitBinding.banner.start();
    }

    @Override
    public void showAdvertisement(List<Advertisement> advertisements) {
        mAdverStringList.clear();
        mFragmentCurrentHitBinding.atvAdvertisement.stop();
        for (int i = 0; i < advertisements.size(); i++) {
            mAdverStringList.add(advertisements.get(i).getAdverName());
        }
        mFragmentCurrentHitBinding.atvAdvertisement.setStringList(mAdverStringList);
        mFragmentCurrentHitBinding.atvAdvertisement.start();
    }

    @Override
    public void showCurrentHit(List<HomepageProgram> programList) {
        mCurrentHitRvAdpter.setProgramList(programList);

    }

    @Override
    public void showProgramList(List<HomepageProgram> programList) {
        mLiveVideoRvAdapter.setProgramList(programList);

    }

}
