package com.orientalfinance.eastcloud.fragment;


import android.content.DialogInterface;
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
import com.orientalfinance.eastcloud.fragment.fragmenthomepage.FragmentCurrentHit;
import com.orientalfinance.eastcloud.fragment.fragmenthomepage.FragmentTVPlay;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.module.javabean.CheckVersionRequestParam;
import com.orientalfinance.eastcloud.module.javabean.CheckVersionResult;
import com.orientalfinance.eastcloud.module.javabean.RecommandCategory;
import com.orientalfinance.eastcloud.mvp.View.HomepageView;
import com.orientalfinance.eastcloud.mvp.base.BaseFragment;
import com.orientalfinance.eastcloud.mvp.presenter.HomePagePresenter;
import com.orientalfinance.eastcloud.update.UpdateService;
import com.orientalfinance.eastcloud.utils.AppUtils;
import com.orientalfinance.eastcloud.utils.LogUtils;
import com.orientalfinance.eastcloud.view.MainGuideDialog;

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
        checkUpdate();
    }

    private void getCategory() {
        RequestParam requestParam = new RequestParam();
        getPresenter().showCategory(requestParam);
    }

    private void checkUpdate() {
        CheckVersionRequestParam checkVersionRequestParam = new CheckVersionRequestParam(AppUtils.getAppVersionCode(getActivity(), getActivity().getPackageName()) + "", Constant.ANDROID);
        RequestParam requestParam = new RequestParam(checkVersionRequestParam);
        getPresenter().checkVersion(requestParam);
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
    public void showCategory(List<RecommandCategory> categories) {
        LogUtils.d(TAG, "showCategory: " + categories.toString());
        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            if (i == 0) {
                fragmentList.add(FragmentCurrentHit.newInstance((ArrayList<RecommandCategory>) categories.get(i).getChild(), ""));
            } else {
                fragmentList.add(FragmentTVPlay.newInstance((ArrayList<RecommandCategory>) categories.get(i).getChild(), ""));

            }
        }
        mFragmentHomePageBinding.vpHomePage.setAdapter(new CurrentHitPageAdapter(getChildFragmentManager(), categories, fragmentList));
        mFragmentHomePageBinding.tabHomepage.setTabMode(TabLayout.MODE_FIXED);
        mFragmentHomePageBinding.tabHomepage.setupWithViewPager(mFragmentHomePageBinding.vpHomePage);
        mFragmentHomePageBinding.vpHomePage.setOffscreenPageLimit(categories.size());

    }

    @Override
    public void checkVersionSucceed(CheckVersionResult checkVersionResult) {
        final String url = checkVersionResult.getDownloadUrl();
        String updateFlag = checkVersionResult.getUpdateFlag();
        if (updateFlag.equals("1")) {
            MainGuideDialog mainGuideDialog = new MainGuideDialog.Builder(getActivity()).setMessage("新版本为强制更新").setTitle("更新").
                    setNegativeButton("不可取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            getActivity().finish();
                        }
                    }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    UpdateService.Builder.create(url).build(getActivity());
                }
            }).create();
            mainGuideDialog.show();
        } else if (updateFlag.equals("2")) {
            MainGuideDialog mainGuideDialog = new MainGuideDialog.Builder(getActivity()).setMessage("新版本为非强制更新").setTitle("更新").
                    setNegativeButton("不可取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    UpdateService.Builder.create(url).build(getActivity());
                }
            }).create();
            mainGuideDialog.show();
        } else if (updateFlag.equals("3")) {
            MainGuideDialog mainGuideDialog = new MainGuideDialog.Builder(getActivity()).setMessage("新版本为最新版本").setTitle("更新").
                    setNegativeButton("不可取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    UpdateService.Builder.create(url).build(getActivity());
                }
            }).create();
            mainGuideDialog.show();
        }
    }
}
