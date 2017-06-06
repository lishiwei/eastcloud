package com.orientalfinance.eastcloud.dagger.component;

import com.orientalfinance.eastcloud.dagger.BaseFragmentComponent;
import com.orientalfinance.eastcloud.dagger.qualifier.PerFragment;
import com.orientalfinance.eastcloud.dagger.modules.ChannelModules;
import com.orientalfinance.eastcloud.fragment.FragmentChannel;

import dagger.Component;

/**
 * Created by 29435 on 2017/5/25.
 */
@PerFragment
@Component(dependencies = AppComponent.class,modules = ChannelModules.class)
public interface ChannelComponent extends BaseFragmentComponent<FragmentChannel>{

}
