package com.orientalfinance.eastcloud.dagger.component;

import com.orientalfinance.eastcloud.dagger.BaseFragmentComponent;
import com.orientalfinance.eastcloud.dagger.qualifier.PerFragment;
import com.orientalfinance.eastcloud.dagger.modules.ShangHaiModules;
import com.orientalfinance.eastcloud.fragment.fragmentchannel.FragmentShangHai;

import dagger.Component;

/**
 * Created by 29435 on 2017/5/26.
 */
@PerFragment
@Component(dependencies = AppComponent.class,modules = ShangHaiModules.class)
public interface ShangHaiComponent extends BaseFragmentComponent<FragmentShangHai>{
}
