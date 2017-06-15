package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityAddFamilyMemberBinding;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.FamilyMember;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.AddFamilyMemberView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.AddFamilyMemberPresenter;
import com.orientalfinance.eastcloud.view.MSGCountTimeView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

public class ActivityAddFamilyMember extends BaseMVPActivity<AddFamilyMemberView, AddFamilyMemberPresenter> implements AddFamilyMemberView {
    ActivityAddFamilyMemberBinding mActivityAddFamilyMemberBinding;
    String mPhone;
    String msgId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityAddFamilyMemberBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_family_member);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mActivityAddFamilyMemberBinding.tvGetCode.setTotaltime(10000);
        mActivityAddFamilyMemberBinding.tvGetCode.isAllowRun(true);
        mActivityAddFamilyMemberBinding.tvGetCode.onDownTime(new MSGCountTimeView.onDownTime() {

            @Override
            public void onClick() {
                mPhone = mActivityAddFamilyMemberBinding.etPhoneNumber.getText().toString();

                mActivityAddFamilyMemberBinding.tvGetCode.setBackgroundDrawable(getDrawable(R.drawable.grey_rectangle));
                User.SendCodeRequestParam sendCodeRequestParam = new User.SendCodeRequestParam(mPhone);

                getPresenter().sendVerificationCode(new RequestParam<User.SendCodeRequestParam>(sendCodeRequestParam));
            }

            @Override
            public void onCount() {
            }

            @Override
            public void onFinish() {

                mActivityAddFamilyMemberBinding.tvGetCode.setBackgroundDrawable(getDrawable(R.drawable.bg_movieproperty));
            }
        });
        mActivityAddFamilyMemberBinding.btnAddFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FamilyMember.AddFamilyRequestParam addFamilyRequestParam = new FamilyMember.AddFamilyRequestParam("", "", mPhone, "");
                getPresenter().addFamilyMember(new RequestParam<FamilyMember.AddFamilyRequestParam>(addFamilyRequestParam));
            }
        });
    }

    @Override
    public void showCodeSucceed(String msgId) {
        this.msgId = msgId;
    }

    @NonNull
    @Override
    public AddFamilyMemberPresenter createPresenter() {
        return new AddFamilyMemberPresenter();
    }

    @Override
    public void showDialog() {
        mEastCloudDialog.show();
    }

    @Override
    public void hideDialog() {
        mEastCloudDialog.hide();
    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public void showAddSucceed() {
        Toast.makeText(this, "添加成功!", Toast.LENGTH_SHORT).show();
        Flowable.timer(2, TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull Long aLong) throws Exception {
                finish();
            }
        });

    }
}
