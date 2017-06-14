package com.orientalfinance.eastcloud.utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 29435 on 2017/6/14.
 */

public class IntentUtils {

    public static void startIntent(AppCompatActivity resActivity, AppCompatActivity desActivity, Intent intent)
    {
        resActivity.startActivity(intent);
    }
    public static void startIntent(AppCompatActivity resActivity, Class<? extends AppCompatActivity>  desActivity)
    {
        Intent intent = new Intent(resActivity,desActivity.getClass());
        resActivity.startActivity(intent);
    }
}
