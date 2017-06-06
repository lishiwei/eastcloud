package com.orientalfinance.eastcloud;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
import com.orientalfinance.eastcloud.utils.FragmentIndicator;

public class MainActivity extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

}
