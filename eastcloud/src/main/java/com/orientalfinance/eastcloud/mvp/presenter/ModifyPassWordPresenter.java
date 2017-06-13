package com.orientalfinance.eastcloud.mvp.presenter;


import com.orientalfinance.eastcloud.module.Retrofit.HttpCallBack;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.javabean.UpdatePasswordParam;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.ModifyPassWordView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ModifyPassWordPresenter extends MvpNullObjectBasePresenter<ModifyPassWordView> {
    private static final String TAG = ModifyPassWordPresenter.class.getSimpleName();


    public void regist(UpdatePasswordParam updatePasswordParam) {

        getView().showModify();
        RemoteDataProxy.forgetPwd(new RequestParam<UpdatePasswordParam>(updatePasswordParam), new HttpCallBack<User>() {
            @Override
            public void OnSuccess(User data) {
                getView().hideModify();
                getView().ModifySucceed(data);
            }

            @Override
            public void onFailure(String errorMsg) {
                getView().showError(errorMsg);
                getView().hideModify();
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    @Override
    public void start() {

    }
}
