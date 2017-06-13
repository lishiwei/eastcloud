package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityModifyPassWordBinding;
import com.orientalfinance.eastcloud.module.core.AcacheUtil;
import com.orientalfinance.eastcloud.module.javabean.UpdatePasswordParam;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.ModifyPassWordView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.ModifyPassWordPresenter;

public class ActivityModifyPassWord extends BaseMVPActivity<ModifyPassWordView, ModifyPassWordPresenter> implements ModifyPassWordView {
    ActivityModifyPassWordBinding mActivityModifyPassWordBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityModifyPassWordBinding = DataBindingUtil.setContentView(this, R.layout.activity_modify_pass_word);

        mActivityModifyPassWordBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().regist(new UpdatePasswordParam(AcacheUtil.getInstance().getUser().getPhone(), mActivityModifyPassWordBinding.etPassWord.getText().toString()));
            }
        });
    }

    @NonNull
    @Override
    public ModifyPassWordPresenter createPresenter() {
        return new ModifyPassWordPresenter();
    }

    @Override
    public void showModify() {
        mEastCloudDialog.show();
    }

    @Override
    public void hideModify() {
        mEastCloudDialog.hide();
    }

    @Override
    public void showError(String throwable) {
        Toast.makeText(this, getString(R.string.req_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ModifySucceed(User user) {
        AcacheUtil.getInstance().getUser().setPwd(mActivityModifyPassWordBinding.etPassWord.getText().toString());
        startActivity(new Intent(this, ActivityLogin.class));
    }
}
