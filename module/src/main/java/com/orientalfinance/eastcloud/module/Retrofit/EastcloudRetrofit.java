package com.orientalfinance.eastcloud.module.Retrofit;


import android.support.annotation.NonNull;

import com.orientalfinance.eastcloud.module.Retrofit.configration.API;
import com.orientalfinance.eastcloud.module.Retrofit.encrypt.DecryptionInterceptor;
import com.orientalfinance.eastcloud.module.Retrofit.log.LogParamsInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by 29435 on 2017/5/31.
 */

public class EastcloudRetrofit {
    public static EastcloudRetrofit eastcloudRetrofit;
    private static final Object objectLock = new Object();
    private static Retrofit retrofit;

    private EastcloudRetrofit() {
        retrofit = initRetrofit();
    }

    private Retrofit initRetrofit() {
        OkHttpClient mOkHttpClient = getOkHttpClient();
        retrofit = new Retrofit.Builder().client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API.BASE_URL)
                .build();
        return retrofit;
    }

    public static EastcloudRetrofit getInstance() {
        if (eastcloudRetrofit == null) {
            synchronized (objectLock) {
                if (eastcloudRetrofit == null) {
                    eastcloudRetrofit = new EastcloudRetrofit();
                }
            }
        }
        return eastcloudRetrofit;
    }

    public EastCloudService getEastCloudService() {
        if (retrofit == null) {
            retrofit = initRetrofit();
        }

        return retrofit.create(EastCloudService.class);
    }

    @NonNull
    private static OkHttpClient getOkHttpClient() {
        LogParamsInterceptor log = new LogParamsInterceptor.Builder().showLog(true).build();
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(15000, TimeUnit.SECONDS)
                .writeTimeout(20000, TimeUnit.SECONDS)
                .readTimeout(20000, TimeUnit.SECONDS)
                .addInterceptor(log)

                .addInterceptor(new DecryptionInterceptor());

        return builder.build();
    }

}
