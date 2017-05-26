package com.orientalfinance.eastcloud.dagger;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lishiwei on 2017/3/31.
 */

public interface BaseFragmentComponent<FRAGMENT extends Fragment> {
void inject(FRAGMENT fragment);
}
