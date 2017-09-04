package com.orientalfinance.eastcloud.mvp.View;

import com.orientalfinance.eastcloud.module.javabean.Message;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public interface MessageView extends BaseMvpView {

    public void showMessage(List<Message> details);

}
