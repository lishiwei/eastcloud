package com.orientalfinance.eastcloud.dagger.component;

import com.orientalfinance.eastcloud.activity.ActivityMyBankCard;
import com.orientalfinance.eastcloud.dagger.BaseActivityComponent;
import com.orientalfinance.eastcloud.dagger.modules.ActivityBankCardModule;
import com.orientalfinance.eastcloud.dagger.qualifier.PerActivity;

import dagger.Component;

/**
 * Created by lishiwei on 2017/3/31.
 */
@PerActivity
@Component(dependencies = AppComponent.class,modules = ActivityBankCardModule.class)
public interface ActivityBankCardComponent extends BaseActivityComponent<ActivityMyBankCard> {

}
