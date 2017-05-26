package com.orientalfinance.eastcloud.dagger.component;

import com.orientalfinance.eastcloud.dagger.BaseFragmentComponent;
import com.orientalfinance.eastcloud.dagger.PerFragment;
import com.orientalfinance.eastcloud.dagger.modules.CurrentHitModule;
import com.orientalfinance.eastcloud.fragment.fragmenthomepage.FragmentCurrentHit;

import dagger.Component;

/**
 * Created by 29435 on 2017/5/26.
 */
@PerFragment
@Component(dependencies = AppComponent.class,modules = CurrentHitModule.class)
public interface CurrentHitComponent extends BaseFragmentComponent<FragmentCurrentHit>{
}
