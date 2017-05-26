package com.orientalfinance.eastcloud.dagger.component;

import com.orientalfinance.eastcloud.dagger.BaseFragmentComponent;
import com.orientalfinance.eastcloud.dagger.PerFragment;
import com.orientalfinance.eastcloud.dagger.modules.HomePageModules;
import com.orientalfinance.eastcloud.fragment.FragmentHomePage;

import dagger.Component;

/**
 * Created by 29435 on 2017/5/25.
 */
@PerFragment
@Component(dependencies = AppComponent.class,modules = HomePageModules.class)
public interface HomePageComponent  extends BaseFragmentComponent<FragmentHomePage>{

}
