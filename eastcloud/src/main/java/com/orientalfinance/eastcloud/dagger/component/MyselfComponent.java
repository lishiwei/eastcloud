package com.orientalfinance.eastcloud.dagger.component;

import com.orientalfinance.eastcloud.dagger.BaseFragmentComponent;
import com.orientalfinance.eastcloud.dagger.PerFragment;
import com.orientalfinance.eastcloud.dagger.modules.ChannelModules;
import com.orientalfinance.eastcloud.dagger.modules.MyselfModule;
import com.orientalfinance.eastcloud.fragment.FragmentChannel;
import com.orientalfinance.eastcloud.fragment.FragmentMySelf;

import dagger.Component;

/**
 * Created by 29435 on 2017/5/25.
 */
@PerFragment
@Component(dependencies = AppComponent.class,modules = MyselfModule.class)
public interface MyselfComponent extends BaseFragmentComponent<FragmentMySelf>{

}
