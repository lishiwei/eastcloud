package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.HomepageProgram;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface TVPlayView extends BaseMvpView{
  public void showProgramList(String categoryId,List<HomepageProgram> programList);

}
