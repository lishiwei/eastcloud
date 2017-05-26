package com.orientalfinance.eastcloud.dagger;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by lishiwei on 2017/3/31.
 */

public interface BaseActivityComponent <ACTVITY extends AppCompatActivity> {
void inject(ACTVITY actvity);
}
