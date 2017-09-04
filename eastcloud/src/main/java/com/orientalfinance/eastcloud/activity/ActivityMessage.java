package com.orientalfinance.eastcloud.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.javabean.Message;
import com.orientalfinance.eastcloud.mvp.View.MessageView;
import com.orientalfinance.eastcloud.mvp.base.BaseMVPActivity;
import com.orientalfinance.eastcloud.mvp.presenter.MessagePresenter;

import java.util.List;

public class ActivityMessage extends BaseMVPActivity<MessageView,MessagePresenter> implements MessageView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
    }

    @NonNull
    @Override
    public MessagePresenter createPresenter() {
        return new MessagePresenter();
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public void showMessage(List<Message> details) {

    }
}
