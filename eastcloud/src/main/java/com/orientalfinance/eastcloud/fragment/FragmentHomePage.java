package com.orientalfinance.eastcloud.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.orientalfinance.R;
import com.orientalfinance.databinding.FragmentHomePageBinding;
import com.orientalfinance.eastcloud.adapter.CurrentHitPageAdapter;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerHomePageComponent;
import com.orientalfinance.eastcloud.dagger.component.HomePageComponent;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.HomePageChannel;
import com.orientalfinance.eastcloud.mvp.View.HomepageView;
import com.orientalfinance.eastcloud.mvp.base.BaseFragment;
import com.orientalfinance.eastcloud.mvp.presenter.HomePagePresenter;
import com.orientalfinance.eastcloud.utils.LogUtils;
import com.orientalfinance.eastcloud.utils.PrivateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHomePage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHomePage extends BaseFragment<HomePageComponent, HomepageView, HomePagePresenter> implements HomepageView {
    static String TAG = FragmentHomePage.class.getSimpleName();
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


    List<String> mImageUrl = new ArrayList<>();

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
        getCategory();
    }

    private void getCategory() {
        RequestParam requestParam = new RequestParam();
        getPresenter().showCategory(requestParam);
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
    public void showCategory(List<HomePageChannel.Category> categories) {
        LogUtils.d(TAG, "showCategory: "+categories.toString());
        List<String> categoryTitle = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {

            categoryTitle.add(categories.get(i).getCateName());

        }
        if (categoryTitle.size()>5)
        {
            for (int i = 5; i < categoryTitle.size() ; i++) {
                categoryTitle.remove(categoryTitle.get(i));
            }
        }
        mFragmentHomePageBinding.vpHomePage.setAdapter(new CurrentHitPageAdapter(getChildFragmentManager(), categoryTitle));
        mFragmentHomePageBinding.tabHomepage.setTabMode(TabLayout.MODE_FIXED);
        mFragmentHomePageBinding.tabHomepage.setupWithViewPager(mFragmentHomePageBinding.vpHomePage);

        mFragmentHomePageBinding.vpHomePage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
           int m = (int) PrivateUtil.invoke(mFragmentHomePageBinding.tabHomepage, "calculateScrollXForTab", new Class[] { int.class,float.class },
                        new Object[] { position,positionOffset });
                LogUtils.d(TAG, "onPageScrolled: "+m);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
