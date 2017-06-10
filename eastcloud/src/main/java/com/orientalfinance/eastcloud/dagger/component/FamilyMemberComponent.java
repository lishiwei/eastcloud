package com.orientalfinance.eastcloud.dagger.component;

import com.orientalfinance.eastcloud.activity.ActivityFamilyMember;
import com.orientalfinance.eastcloud.dagger.BaseActivityComponent;
import com.orientalfinance.eastcloud.dagger.modules.ActivityFamilyMemberModules;
import com.orientalfinance.eastcloud.dagger.qualifier.PerActivity;

import dagger.Component;

/**
 * Created by lishiwei on 2017/3/31.
 */
@PerActivity
@Component(dependencies = AppComponent.class,modules = ActivityFamilyMemberModules.class)
public interface FamilyMemberComponent extends BaseActivityComponent<ActivityFamilyMember> {

}
