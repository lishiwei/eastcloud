package com.orientalfinance.eastcloud.module.Retrofit;

import android.util.Log;

import com.orientalfinance.eastcloud.module.Retrofit.configration.HttpCode;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 类描述：响应数据回调
 * Created by lzy on 2017/6/10.
 * email:lizy@oriental-finance.com
 */
public abstract class HttpCallBack<T> implements Callback<RequestResult<T>> {

    @Override
    public void onResponse(Call<RequestResult<T>> call, Response<RequestResult<T>> response) {
        Log.e("TAG", response.headers().toString());
        if (response.isSuccessful()) {
            RequestResult<T> body = response.body();
            int statusCode = body.getCode();
            if (statusCode > 0) {
                if (statusCode == HttpCode.SUCCESS) {
                    OnSuccess(body.getResult());
                }
            } else {
                onFailure(body.getMsg());
            }

            onCompleted();
        } else {
            //服务器响应失败
            onFailure("服务器异常");
            onCompleted();
        }
    }

    @Override
    public void onFailure(Call<RequestResult<T>> call, Throwable t) {
        String localizedMessage = t.getLocalizedMessage();
        onFailure(localizedMessage);
        onCompleted();
    }

    public abstract void OnSuccess(T data);

    public abstract void onFailure(String errorMsg);

    public abstract void onCompleted();
}
