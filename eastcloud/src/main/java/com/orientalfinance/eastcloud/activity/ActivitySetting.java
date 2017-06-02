package com.orientalfinance.eastcloud.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivitySettingBinding;

public class ActivitySetting extends AppCompatActivity {
ActivitySettingBinding mActivitySettingBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mActivitySettingBinding = DataBindingUtil.setContentView(this,R.layout.activity_setting);
        mActivitySettingBinding.setUrl(R.drawable.myself+"");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
