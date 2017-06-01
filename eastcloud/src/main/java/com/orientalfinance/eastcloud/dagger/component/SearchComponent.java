package com.orientalfinance.eastcloud.dagger.component;

import android.support.v7.app.AppCompatActivity;

import com.orientalfinance.eastcloud.activity.ActivityDetail;
import com.orientalfinance.eastcloud.activity.ActivitySearch;
import com.orientalfinance.eastcloud.dagger.BaseActivityComponent;
import com.orientalfinance.eastcloud.dagger.PerActivity;
import com.orientalfinance.eastcloud.dagger.modules.SearchModule;

import dagger.Component;

/**
 * Created by lishiwei on 2017/3/31.
 */
@PerActivity
@Component(dependencies = AppComponent.class,modules = SearchModule.class)
public interface SearchComponent extends BaseActivityComponent<ActivitySearch> {

}
