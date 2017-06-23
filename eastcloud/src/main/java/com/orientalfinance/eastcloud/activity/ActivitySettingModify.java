package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.ClearEditText;
import com.orientalfinance.eastcloud.mvp.View.SettingModifyView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.SettingModifyPresenter;

public class ActivitySettingModify extends BaseMVPActivity<SettingModifyView, SettingModifyPresenter> implements SettingModifyView {
    String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_modify);
        final Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra(Constant.TITLE);
            ((TextView) findViewById(R.id.tv_toolbar)).setText(title);
        }
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((ClearEditText) findViewById(R.id.clearEditText)).setHint(getIntent().getStringExtra(Constant.TITLE));
        findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(((ClearEditText) findViewById(R.id.clearEditText)).getText())) {
                    content = ((ClearEditText) findViewById(R.id.clearEditText)).getText().toString();
                    User.ModifyRequestParam modifyRequestParam = new User.ModifyRequestParam();
                    switch (intent.getStringExtra(Constant.TITLE)) {
                        case "修改昵称":
                            modifyRequestParam.setNick_name(content);
                            break;
                        case "修改真实姓名":
                            modifyRequestParam.setReal_name(content);
                            break;
                        case "修改手机号码":
                            modifyRequestParam.setPhone(content);
                            break;
                    }

                    getPresenter().modifyUserInfo(new RequestParam(modifyRequestParam));
                } else {
                    Toast.makeText(ActivitySettingModify.this, "您未填写任何内容！", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @NonNull
    @Override
    public SettingModifyPresenter createPresenter() {
        return new SettingModifyPresenter();
    }

    @Override
    public void showSucceed() {
        Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent();
        intent1.putExtra(Constant.VALUE, content);
        setResult(getIntent().getIntExtra(Constant.REQUEST_CODE, Constant.REALNAME), intent1);
        finish();
    }

    @Override
    public void showDialog() {
        mEastCloudProgressDialog.show();
    }

    @Override
    public void hideDialog() {
        mEastCloudProgressDialog.hide();
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, "修改失败!", Toast.LENGTH_SHORT).show();
    }
}
