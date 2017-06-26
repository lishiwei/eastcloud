package com.orientalfinance.eastcloud.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jakewharton.rxbinding2.view.RxView;
import com.orientalfinance.R;
import com.orientalfinance.databinding.FragmentMySelfBinding;
import com.orientalfinance.eastcloud.activity.ActivityLogin;
import com.orientalfinance.eastcloud.activity.ActivityMyOrder;
import com.orientalfinance.eastcloud.adapter.MyselfRvAdapter;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;
import com.orientalfinance.eastcloud.dagger.component.DaggerMyselfComponent;
import com.orientalfinance.eastcloud.dagger.component.MyselfComponent;
import com.orientalfinance.eastcloud.dagger.modules.MyselfModule;
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.module.core.AcacheUtil;
import com.orientalfinance.eastcloud.mvp.View.FullyGridLayoutManager;
import com.orientalfinance.eastcloud.mvp.View.MyselfView;
import com.orientalfinance.eastcloud.mvp.base.BaseFragment;
import com.orientalfinance.eastcloud.mvp.presenter.MyselfPresenter;
import com.orientalfinance.eastcloud.utils.ClickHandler;
import com.orientalfinance.eastcloud.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Timed;

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
    private static final String TAG = FragmentMySelf.class.getSimpleName();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @Inject
    MyselfRvAdapter mMyselfRvAdapter;

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
    public void onResume() {
        super.onResume();
        if (AcacheUtil.getInstance().getUser() != null) {
            mFragmentMySelfBinding.tvUserName.setText(AcacheUtil.getInstance().getUser().getName() == null ? AcacheUtil.getInstance().getUser().getPhone() : AcacheUtil.getInstance().getUser().getName());

        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFragmentMySelfBinding = (FragmentMySelfBinding) mViewDataBinding;
        mFragmentMySelfBinding.setAvatarUrl("" + R.drawable.myself);
        mFragmentMySelfBinding.rvMyself.setAdapter(mMyselfRvAdapter);
        mFragmentMySelfBinding.rvMyself.setLayoutManager(new FullyGridLayoutManager(getActivity(), 3, LinearLayoutManager.VERTICAL, false));
        mFragmentMySelfBinding.tvUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActivityLogin.class);
                startActivity(intent);
            }
        });

        mFragmentMySelfBinding.setClickHandler(mClickHandler);
      final List<Integer> integerList = new ArrayList<>();
        RxView.clicks(getView().findViewById(R.id.fl_All_Order)).create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
            }
        }).timestamp().subscribe(new Consumer<Timed<Integer>>() {
            @Override
            public void accept(@NonNull Timed<Integer> integerTimed) throws Exception {
                LogUtils.d(TAG, "accept: time" + integerTimed.time());
                LogUtils.d(TAG, "accept:value( " + integerTimed.value());
                if (integerTimed.time() - time < 1000) {
                    integerList.add(integerTimed.value());

                } else {
                    integerList.add(integerTimed.value());
                    LogUtils.d(TAG, "accept: integerList" + integerList.toString());

                }
                time = integerTimed.time();

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                LogUtils.d(TAG, "accept: "+throwable.toString());
            }
        });;


    }

    final List<Integer> integerList = new ArrayList<>();
    static long time;
    ClickHandler mClickHandler = new ClickHandler() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), ActivityMyOrder.class);
            switch (view.getId()) {
                case R.id.fl_All_Order:
                    intent.putExtra(Constant.VALUE, Constant.ALLORDER);



                    break;
                case R.id.fl_UnPaid:
                    intent.putExtra(Constant.VALUE, Constant.UNPAID);
                    break;
                case R.id.fl_Undelivery:
                    intent.putExtra(Constant.VALUE, Constant.UNDELIVERY);
                    break;
                case R.id.fl_UnRecieved:
                    intent.putExtra(Constant.VALUE, Constant.UNRECIEVED);
                    break;
                case R.id.fl_Succeed:
                    intent.putExtra(Constant.VALUE, Constant.SUCCEED);
                    break;
            }
//            startActivity(intent);
        }
    };
}
