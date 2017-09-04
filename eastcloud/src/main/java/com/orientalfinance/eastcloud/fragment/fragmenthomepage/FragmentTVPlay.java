package com.orientalfinance.eastcloud.fragment.fragmenthomepage;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;

import com.orientalfinance.R;
import com.orientalfinance.databinding.FragmentTvplayBinding;
import com.orientalfinance.eastcloud.adapter.ProgramHorizontalViewBinder;
import com.orientalfinance.eastcloud.adapter.ProgramViewBinder;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerTvPlayComponent;
import com.orientalfinance.eastcloud.dagger.component.TvPlayComponent;
import com.orientalfinance.eastcloud.dagger.modules.TVPlayModule;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.HomePageChannel;
import com.orientalfinance.eastcloud.module.javabean.HomepageProgram;
import com.orientalfinance.eastcloud.module.javabean.HorizontalProgram;
import com.orientalfinance.eastcloud.module.javabean.RecommandCategory;
import com.orientalfinance.eastcloud.mvp.View.FullyGridLayoutManager;
import com.orientalfinance.eastcloud.mvp.View.TVPlayView;
import com.orientalfinance.eastcloud.mvp.base.BaseFragment;
import com.orientalfinance.eastcloud.mvp.presenter.TVPlayPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTVPlay#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTVPlay extends BaseFragment<TvPlayComponent, TVPlayView, TVPlayPresenter> implements TVPlayView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private ArrayList<RecommandCategory> mParam1;
    private String mParam2;

    @Inject
    List<String> mStringList;

    FragmentTvplayBinding mFragmentTvplayBinding;
    @VisibleForTesting
    MultiTypeAdapter adapter;

    List<Object> items = new ArrayList<>();

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
    public static FragmentTVPlay newInstance(ArrayList<RecommandCategory> param1, String param2) {
        FragmentTVPlay fragment = new FragmentTVPlay();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getParcelableArrayList(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFragmentTvplayBinding = (FragmentTvplayBinding) mViewDataBinding;

        adapter = new MultiTypeAdapter();


        adapter.register(HorizontalProgram.class, new ProgramHorizontalViewBinder());

        adapter.register(HomepageProgram.class, new ProgramViewBinder());

        final GridLayoutManager layoutManager = new FullyGridLayoutManager(getContext(), 2);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {

            @Override
            public int getSpanSize(int position) {
                Object item = items.get(position);
                return item instanceof HorizontalProgram ? 2 : 1;
            }
        };
        layoutManager.setSpanSizeLookup(spanSizeLookup);
        mFragmentTvplayBinding.rvPlay.setLayoutManager(layoutManager);
        mFragmentTvplayBinding.rvPlay.setAdapter(adapter);
        adapter.setItems(items);
        mFragmentTvplayBinding.scrollview.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
        getData();
    }

    private void getData() {
        for (int i = 0; i < mParam1.size(); i++) {
            HomePageChannel.ShowChannelRequestParam requestParam = new HomePageChannel.ShowChannelRequestParam(mParam1.get(i).getCateId());
            RequestParam requestParam1 = new RequestParam(requestParam);
            getPresenter().showProgramList(requestParam1);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tvplay;
    }

    @Override
    protected TvPlayComponent constructComponent(AppComponent appComponent) {
        return DaggerTvPlayComponent.builder().appComponent(appComponent).tVPlayModule(new TVPlayModule()).build();
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
    public void showProgramList(String categoryId, List<HomepageProgram> programList) {

        if (mFragmentTvplayBinding.scrollview.isRefreshing())
        {
            mFragmentTvplayBinding.scrollview.setRefreshing(false);
        }

        HorizontalProgram horizontalProgram = null;
        if (programList.get(0) == null) {
            return;
        }
        horizontalProgram = new HorizontalProgram(programList.get(0));
        for (int i = 0; i < mParam1.size(); i++) {
            if (mParam1.get(i).getCateId().equals(categoryId)) {

                horizontalProgram.setCategoryName(mParam1.get(i).getCateName());
                items.add(horizontalProgram);
                break;
            }
        }
        items.addAll(programList.subList(1, programList.size() - 1));
        adapter.notifyDataSetChanged();
    }
}
