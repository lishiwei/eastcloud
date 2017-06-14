package com.orientalfinance.eastcloud.module.Retrofit.convert;

import android.util.Log;

import com.google.gson.Gson;
import com.orientalfinance.eastcloud.module.Retrofit.ApiException;
import com.orientalfinance.eastcloud.module.Retrofit.HttpResult;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by lzy on 2017/6/13.
 * email:lizy@oriental-finance.com
 */

class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;

    GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        Log.d("Network", "response>>" + response);
        //httpResult 只解析result字段
        HttpResult httpResult = gson.fromJson(response, HttpResult.class);
        //
        if (httpResult.getCode() < 0) {
            throw new ApiException(httpResult.getCode(), httpResult.getMsg());
        }
        return gson.fromJson(response, type);


    }
}
