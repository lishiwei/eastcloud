package com.orientalfinance.eastcloud.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.orientalfinance.R;
import com.orientalfinance.databinding.ActivityConnectTvBinding;
import com.orientalfinance.eastcloud.utils.LogUtils;
import com.orientalfinance.eastcloud.zxing.ScannerActivity;

public class ActivityConnectTV extends AppCompatActivity {
    ActivityConnectTvBinding mActivityConnectTvBinding;
static String TAG = ActivityConnectTV.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityConnectTvBinding = DataBindingUtil.setContentView(this, R.layout.activity_connect_tv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        mActivityConnectTvBinding.ivScanCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.d(TAG, "onClick: ");
                scanCode();
            }
        });
    }

    private void scanCode() {
        if (ContextCompat.checkSelfPermission(ActivityConnectTV.this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            //权限还没有授予，需要在这里写申请权限的代码
            ActivityCompat.requestPermissions(ActivityConnectTV.this,
                    new String[]{Manifest.permission.CAMERA}, 60);
        } else {
            //权限已经被授予，在这里直接写要执行的相应方法即可
            ScannerActivity.gotoActivity(ActivityConnectTV.this,
                    false, 0);
        }
    }
}
