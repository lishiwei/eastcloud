package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityAddBankCardBinding;
import com.orientalfinance.eastcloud.mvp.View.ActivityAddBankCardView;
import com.orientalfinance.eastcloud.mvp.presenter.ActivityAddBankCardPresenter;
import com.orientalfinance.eastcloud.view.MSGCountTimeView;

public class ActivityAddBankCard extends MvpActivity<ActivityAddBankCardView, ActivityAddBankCardPresenter>
        implements View.OnClickListener {

    private ActivityAddBankCardBinding viewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_bank_card);
        initViews();
    }

    private void initViews() {
        viewDataBinding.toolbar.setTitle("");
        setSupportActionBar(viewDataBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewDataBinding.btnAddBankCard.setOnClickListener(this);
//        viewDataBinding.tvGetCode.setTotaltime(10000);
//        viewDataBinding.tvGetCode.isAllowRun(true);
//        viewDataBinding.tvGetCode.onDownTime(new MSGCountTimeView.onDownTime() {
//            @Override
//            public void onClick() {
//                viewDataBinding.tvGetCode.setBackgroundResource(R.drawable.msg_btn_gray_bg);
//                Log.e("TAG", "tvGetCode被点击");
//                //请求发送验证码
//            }
//
//            @Override
//            public void onCount() {
//
//            }
//
//            @Override
//            public void onFinish() {
//                viewDataBinding.tvGetCode.setBackgroundResource(R.drawable.btn_red_bg);
//            }
//        });

    }

    @NonNull
    @Override
    public ActivityAddBankCardPresenter createPresenter() {
        return new ActivityAddBankCardPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_bank_card:
                //TODO:
                startActivity(new Intent(ActivityAddBankCard.this, ActivitySettingPayPwd.class));
                break;
        }
    }
}
