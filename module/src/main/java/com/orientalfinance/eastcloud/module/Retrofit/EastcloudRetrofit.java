package com.orientalfinance.eastcloud.module.Retrofit;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by 29435 on 2017/5/31.
 */

public class EastcloudRetrofit {
    public static String BaseUrl = "";
    public static EastCloudService getRetrofitService() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS);

        OkHttpClient mOkHttpClient=builder.build();
        Retrofit retrofit = new Retrofit.Builder().client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BaseUrl)
                .build();
        EastCloudService retrofitService = retrofit.create(EastCloudService.class);

        return retrofitService;

    }

}
