package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.HttpCallBack;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.ControllerRequest;
import com.orientalfinance.eastcloud.mvp.View.FragmentRemoteControlView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import java.io.File;

import static com.orientalfinance.eastcloud.fragment.FragmentRemoteControl.MANUAL_INPUT;
import static com.orientalfinance.eastcloud.fragment.FragmentRemoteControl.MSG_NOTIFY;
import static com.orientalfinance.eastcloud.fragment.FragmentRemoteControl.TV_PAY;
import static com.orientalfinance.eastcloud.fragment.FragmentRemoteControl.TV_TOU;
import static com.orientalfinance.eastcloud.fragment.FragmentRemoteControl.TV_VOICE_INPUT;

/**
 * Created by lzy on 2017/6/27.
 * email:lizy@oriental-finance.com
 */

public class FragmentRemoteControlPresenter extends MvpNullObjectBasePresenter<FragmentRemoteControlView> {

    public void requestNet(int type) {
        ControllerRequest controllerRequest = new ControllerRequest();
        File file;
        switch (type) {
            case TV_PAY:
                controllerRequest.setKey("pay");
                controllerRequest.setContent("");
                file = new File("");
                realRequest(controllerRequest, file);
                break;
            case TV_VOICE_INPUT:
                controllerRequest.setKey("inform");
                controllerRequest.setContent("");
                file = new File("");
                realRequest(controllerRequest, file);
                break;
            case MANUAL_INPUT:
                controllerRequest.setKey("input");
                controllerRequest.setContent("");
                file = new File("");
                realRequest(controllerRequest, file);
                break;
            case MSG_NOTIFY:
                controllerRequest.setKey(" input");
                controllerRequest.setContent("");
                file = new File("");
                realRequest(controllerRequest, file);
                break;
            case TV_TOU:
                controllerRequest.setKey("image");
                controllerRequest.setContent("");
                file = new File("");
                realRequest(controllerRequest, file);

                break;
        }

    }


    private void realRequest(ControllerRequest controllerRequest, File file) {

    }

    private void realQuestWithNoFile() {
        ControllerRequest controllerRequest = new ControllerRequest();
        controllerRequest.setKey("pay");
        controllerRequest.setContent("");
        RequestParam<ControllerRequest> requestParam = new RequestParam<>(controllerRequest);

        RemoteDataProxy.controller(requestParam, null, new HttpCallBack() {
            @Override
            public void OnSuccess(Object data) {
                getView().onSuccess("支付成功");
            }

            @Override
            public void onFailure(String errorMsg) {
                getView().onError(errorMsg);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void realQuestWithFile() {
        RequestParam<Object> objectRequestParam = new RequestParam<>();
    }
}
