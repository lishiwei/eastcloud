package com.orientalfinance.eastcloud.mvp.presenter;


import android.util.Log;
import android.widget.Toast;

import com.orientalfinance.eastcloud.App;
import com.orientalfinance.eastcloud.module.Retrofit.DeviceUtil;
import com.orientalfinance.eastcloud.module.Retrofit.EastCloudService;
import com.orientalfinance.eastcloud.module.Retrofit.EastcloudRetrofit;
import com.orientalfinance.eastcloud.module.Retrofit.HttpCallBack;
import com.orientalfinance.eastcloud.module.Retrofit.MyTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.Retrofit.RequestResult;
import com.orientalfinance.eastcloud.module.Retrofit.encrypt.EncryptUtils;
import com.orientalfinance.eastcloud.module.core.CommonRequestParam;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.SettingPassWordView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;

import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by 29435 on 2017/5/26.
 */

public class SettingPassWordPresenter extends MvpNullObjectBasePresenter<SettingPassWordView> {
    private static final String TAG = SettingPassWordPresenter.class.getSimpleName();

    @Override
    public void attachView(SettingPassWordView view) {

    }

    @Override
    public void detachView(boolean retainInstance) {

    }

    public void register() {


    }

    public void start() {


    }
}
