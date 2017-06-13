package com.orientalfinance.eastcloud;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.activity.ActivityPlayRecord;
import com.orientalfinance.eastcloud.fragment.FragmentApplication;
import com.orientalfinance.eastcloud.fragment.FragmentChannel;
import com.orientalfinance.eastcloud.fragment.FragmentHomePage;
import com.orientalfinance.eastcloud.fragment.FragmentMySelf;
import com.orientalfinance.eastcloud.fragment.FragmentRemoteControl;
import com.orientalfinance.eastcloud.utils.BottomNavigationViewHelper;
import com.orientalfinance.eastcloud.view.FragmentIndicator;
import com.orientalfinance.eastcloud.zxing.ScannerActivity;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;


import io.reactivex.functions.Consumer;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    FragmentApplication mFragmentApplication;
    FragmentMySelf mFragmentMySelf;
    FragmentChannel mFragmentDashBoard;
    FragmentHomePage mFragmentHomePage;
    FragmentRemoteControl mFragmentRemoteControl;
    public static String APPLICATION = "application";
    public static String MYSELF = "myself";
    public static String DASHBOARD = "dashboard";
    public static String HOMEPAGE = "homepage";
    public static String REMOTECONTROL = "remotecontrol";
    private TextView mTitle;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTransaction.hide(mFragmentApplication).hide(mFragmentRemoteControl).hide(mFragmentDashBoard).hide(mFragmentMySelf).show(mFragmentHomePage);
                    fragmentTransaction.commitAllowingStateLoss();
                    mTitle.setText("东方遥控宝");
                    return true;
                case R.id.navigation_channel:
                    fragmentTransaction.hide(mFragmentApplication).hide(mFragmentRemoteControl).hide(mFragmentHomePage).hide(mFragmentMySelf).show(mFragmentDashBoard);
                    fragmentTransaction.commitAllowingStateLoss();
                    mTitle.setText(getString(R.string.title_channel));
                    return true;
                case R.id.navigation_application:
                    fragmentTransaction.hide(mFragmentHomePage).hide(mFragmentRemoteControl).hide(mFragmentDashBoard).hide(mFragmentMySelf).show(mFragmentApplication);
                    fragmentTransaction.commitAllowingStateLoss();
                    mTitle.setText(getString(R.string.title_application));

                    return true;
                case R.id.navigation_remotecontrol:
                    fragmentTransaction.hide(mFragmentApplication).hide(mFragmentHomePage).hide(mFragmentDashBoard).hide(mFragmentMySelf).show(mFragmentRemoteControl);
                    fragmentTransaction.commitAllowingStateLoss();
                    mTitle.setText(getString(R.string.title_remote_control));

                    return true;
                case R.id.navigation_myself:
                    fragmentTransaction.hide(mFragmentApplication).hide(mFragmentRemoteControl).hide(mFragmentDashBoard).hide(mFragmentHomePage).show(mFragmentMySelf);
                    fragmentTransaction.commitAllowingStateLoss();
                    mTitle.setText(getString(R.string.title_myself));

                    return true;
            }


            return false;
        }

    };
    private final static String[] MULTI_PERMISSIONS = new String[]{

            Manifest.permission.READ_PHONE_STATE,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissions();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.READ_PHONE_STATE}, 70);
        mTitle = (TextView) toolbar.findViewById(R.id.tv_title);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initFragment();
        initView();
    }


    private void initView() {
        findViewById(R.id.iv_Email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.iv_History).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityPlayRecord.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.iv_ScanCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanCode();
            }
        });
        ((FragmentIndicator) findViewById(R.id.fi_indicator)).setOnIndicateListener(new FragmentIndicator.OnIndicateListener() {
            @Override
            public void onIndicate(View v, int which) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                switch (which) {
                    case 0:
                        fragmentTransaction.hide(mFragmentApplication).hide(mFragmentRemoteControl).hide(mFragmentDashBoard).hide(mFragmentMySelf).show(mFragmentHomePage);
                        fragmentTransaction.commitAllowingStateLoss();
                        mTitle.setText("东方遥控宝");
                        break;
                    case 1:
                        fragmentTransaction.hide(mFragmentApplication).hide(mFragmentRemoteControl).hide(mFragmentHomePage).hide(mFragmentMySelf).show(mFragmentDashBoard);
                        fragmentTransaction.commitAllowingStateLoss();
                        mTitle.setText(getString(R.string.title_channel));
                        break;
                    case 2:
                        fragmentTransaction.hide(mFragmentApplication).hide(mFragmentHomePage).hide(mFragmentDashBoard).hide(mFragmentMySelf).show(mFragmentRemoteControl);
                        fragmentTransaction.commitAllowingStateLoss();
                        mTitle.setText(getString(R.string.title_remote_control));
                        break;
                    case 3:
                        fragmentTransaction.hide(mFragmentHomePage).hide(mFragmentRemoteControl).hide(mFragmentDashBoard).hide(mFragmentMySelf).show(mFragmentApplication);
                        fragmentTransaction.commitAllowingStateLoss();
                        mTitle.setText(getString(R.string.title_application));
                        break;
                    case 4:
                        fragmentTransaction.hide(mFragmentApplication).hide(mFragmentRemoteControl).hide(mFragmentDashBoard).hide(mFragmentHomePage).show(mFragmentMySelf);
                        fragmentTransaction.commitAllowingStateLoss();
                        mTitle.setText(getString(R.string.title_myself));
                        break;
                }
            }
        });
    }


    private void initFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentByTag(HOMEPAGE) == null) {
            mFragmentHomePage = FragmentHomePage.newInstance("", "");
            fragmentTransaction.add(R.id.fragment_container, mFragmentHomePage, HOMEPAGE);
        } else {
            mFragmentHomePage = (FragmentHomePage) fragmentManager.findFragmentByTag(HOMEPAGE);
        }
        if (fragmentManager.findFragmentByTag(DASHBOARD) == null) {
            mFragmentDashBoard = FragmentChannel.newInstance("", "");
            fragmentTransaction.add(R.id.fragment_container, mFragmentDashBoard, DASHBOARD).hide(mFragmentDashBoard);
        } else {
            mFragmentDashBoard = (FragmentChannel) fragmentManager.findFragmentByTag(DASHBOARD);
        }
        if (fragmentManager.findFragmentByTag(REMOTECONTROL) == null) {
            mFragmentRemoteControl = FragmentRemoteControl.newInstance("", "");
            fragmentTransaction.add(R.id.fragment_container, mFragmentRemoteControl, REMOTECONTROL).hide(mFragmentRemoteControl);
        } else {
            mFragmentRemoteControl = (FragmentRemoteControl) fragmentManager.findFragmentByTag(REMOTECONTROL);
        }
        if (fragmentManager.findFragmentByTag(APPLICATION) == null) {
            mFragmentApplication = FragmentApplication.newInstance("", "");
            fragmentTransaction.add(R.id.fragment_container, mFragmentApplication, APPLICATION).hide(mFragmentApplication);
        } else {
            mFragmentApplication = (FragmentApplication) fragmentManager.findFragmentByTag(APPLICATION);
        }
        if (fragmentManager.findFragmentByTag(MYSELF) == null) {
            mFragmentMySelf = FragmentMySelf.newInstance("", "");
            fragmentTransaction.add(R.id.fragment_container, mFragmentMySelf, MYSELF).hide(mFragmentMySelf);
        } else {
            mFragmentMySelf = (FragmentMySelf) fragmentManager.findFragmentByTag(MYSELF);
        }

        if (fragmentTransaction != null) {
            fragmentTransaction.commitAllowingStateLoss();
        }
    }


    private void scanCode() {
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            //权限还没有授予，需要在这里写申请权限的代码
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.CAMERA}, 60);
        } else {
            //权限已经被授予，在这里直接写要执行的相应方法即可
            ScannerActivity.gotoActivity(MainActivity.this,
                    false, 0);
        }
    }

    private void requestPermissions() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .requestEach(Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_CALENDAR,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.CAMERA)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {

                        if (permission.granted) {
                            // 用户已经同意该权限
                            Log.d(TAG, permission.name + " is granted.");
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                            Log.d(TAG, permission.name + " is denied. More info should be provided.");
                        } else {
                            // 用户拒绝了该权限，并且选中『不再询问』
                            Log.d(TAG, permission.name + " is denied.");
                        }
                    }
                });

    }

}
