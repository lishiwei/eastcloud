package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.ModifyPassWordView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.ModifyPassWordPresenter;

public class ActivityModifyPassWord extends BaseMVPActivity<ModifyPassWordView, ModifyPassWordPresenter> implements ModifyPassWordView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_pass_word);


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
    public void showError(Throwable throwable) {
        Toast.makeText(this, getString(R.string.req_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ModifySucceed(User user) {
        startActivity(new Intent(this, ActivityLogin.class));
    }
}
