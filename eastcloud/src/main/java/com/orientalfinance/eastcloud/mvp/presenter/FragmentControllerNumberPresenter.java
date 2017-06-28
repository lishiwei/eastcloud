package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.HttpCallBack;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.ControllerRequest;
import com.orientalfinance.eastcloud.mvp.View.FragmentControllerNumberView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

/**
 * Created by lzy on 2017/6/28.
 * email:lizy@oriental-finance.com
 */

public class FragmentControllerNumberPresenter extends
        MvpNullObjectBasePresenter<FragmentControllerNumberView> {

    /**
     * 更换频道请求
     */
    public void changeChannel(final String channel) {
        ControllerRequest controllerRequest = new ControllerRequest();
        controllerRequest.setContent(channel);
        controllerRequest.setKey("channel");
        controllerRequest.setMac_addr("");
        RequestParam<ControllerRequest> requestParam = new RequestParam<>(controllerRequest);
        RemoteDataProxy.controller(requestParam, null, new HttpCallBack() {
            @Override
            public void OnSuccess(Object data) {
                getView().onSuccess("已切换到频道：" + channel);
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


}
