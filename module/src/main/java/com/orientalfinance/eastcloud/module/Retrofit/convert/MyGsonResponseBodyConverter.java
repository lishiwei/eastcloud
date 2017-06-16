package com.orientalfinance.eastcloud.module.Retrofit.convert;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.orientalfinance.eastcloud.module.Retrofit.ApiException;
import com.orientalfinance.eastcloud.module.Retrofit.EastCloudResponseBody;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import static okhttp3.internal.Util.UTF_8;


/**
 * Created by lzy on 2017/6/13.
 * email:lizy@oriental-finance.com
 */

class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    MyGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        Log.d("Network", "response>>" + response);
        //httpResult 只解析result字段
        EastCloudResponseBody eastCloudResponseBody = gson.fromJson(response, EastCloudResponseBody.class);
        //
        if (Integer.valueOf(eastCloudResponseBody.getCode()) < 0) {
            value.close();
            throw new ApiException(Integer.valueOf(eastCloudResponseBody.getCode()), eastCloudResponseBody.getMsg());
        } else if (Integer.valueOf(eastCloudResponseBody.getCode()) >0&& eastCloudResponseBody.getResult() instanceof List) {
            if (((List) eastCloudResponseBody.getResult()).size() == 0) {
                throw new ApiException(ApiErrorCode.ERROR_NO_DATA, ApiErrorCode.ERROR_NO_DATASTRING);
            }
        }
        MediaType mediaType = value.contentType();
        Charset charset = mediaType != null ? mediaType.charset(UTF_8) : UTF_8;
        ByteArrayInputStream bis = new ByteArrayInputStream(response.getBytes());
        InputStreamReader reader = new InputStreamReader(bis, charset);
        JsonReader jsonReader = gson.newJsonReader(reader);
        try {
            return adapter.read(jsonReader);
        } finally {
            value.close();
        }


    }
}
