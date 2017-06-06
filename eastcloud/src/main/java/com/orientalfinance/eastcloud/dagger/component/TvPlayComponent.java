package com.orientalfinance.eastcloud.dagger.component;

import com.orientalfinance.eastcloud.dagger.BaseFragmentComponent;
import com.orientalfinance.eastcloud.dagger.qualifier.PerFragment;
import com.orientalfinance.eastcloud.dagger.modules.TVPlayModule;
import com.orientalfinance.eastcloud.fragment.fragmenthomepage.FragmentTVPlay;

import dagger.Component;

/**
 * Created by 29435 on 2017/5/26.
 */
@PerFragment
@Component(dependencies = AppComponent.class,modules = TVPlayModule.class)
public interface TvPlayComponent extends BaseFragmentComponent<FragmentTVPlay>{
}
