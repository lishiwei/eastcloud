package com.orientalfinance.eastcloud.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivitySettingBinding;
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;

public class ActivitySetting extends AppCompatActivity {
    private static final java.lang.String TAG = ActivitySetting.class.getSimpleName();
    ActivitySettingBinding mActivitySettingBinding;
    ClickHandler mClickHandler = new ClickHandler() {
        @Override
        public void onclick(View v) {
            switch (v.getId()) {
                case R.id.ll_NickName:
                    Intent intent = new Intent(ActivitySetting.this, ActivitySettingModify.class);
                    intent.putExtra(Constant.TITLE, "修改昵称");
                    intent.putExtra(Constant.REQUEST_CODE, Constant.NICKNAME);
                    startActivityForResult(intent, Constant.NICKNAME);
                    break;
                case R.id.ll_RealName:
                    Intent intent1 = new Intent(ActivitySetting.this, ActivitySettingModify.class);
                    intent1.putExtra(Constant.TITLE, "修改真实姓名");
                    intent1.putExtra(Constant.REQUEST_CODE, Constant.REALNAME);

                    startActivityForResult(intent1, Constant.REALNAME
                    );
                    break;
                case R.id.ll_PhoneNumber:
                    Intent intent2 = new Intent(ActivitySetting.this, ActivitySettingModify.class);
                    intent2.putExtra(Constant.TITLE, "修改手机号码");
                    intent2.putExtra(Constant.REQUEST_CODE, Constant.PHONENUMBER);
                    startActivityForResult(intent2, Constant.PHONENUMBER);
                    break;

            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            
            switch (requestCode) {
                case Constant.NICKNAME:

                    mActivitySettingBinding.tvNickName.setText(data.getStringExtra(Constant.VALUE));
                    break;
                case Constant.REALNAME:
                    mActivitySettingBinding.tvRealName.setText(data.getStringExtra(Constant.VALUE));
                    break;
                case Constant.PHONENUMBER:
                    mActivitySettingBinding.tvPhoneNumber.setText(data.getStringExtra(Constant.VALUE));
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        mActivitySettingBinding = DataBindingUtil.setContentView(this, R.layout.activity_setting);
        mActivitySettingBinding.setUrl(R.drawable.myself + "");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mActivitySettingBinding.setHandler(mClickHandler);
    }

    public interface ClickHandler {
        void onclick(View v);
    }
}
