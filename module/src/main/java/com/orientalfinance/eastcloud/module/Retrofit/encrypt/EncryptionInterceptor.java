package com.orientalfinance.eastcloud.module.Retrofit.encrypt;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * 方法描述：OKHttp加密拦截器
 * Created by lzy on 2017/6/9.
 * email:lizy@oriental-finance.com
 */

public class EncryptionInterceptor implements Interceptor {
    private static final String TAG = EncryptionInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {

//        return chain.proceed(getEncryptionRequest(chain.request()));
        return null;
    }

//    private Request getEncryptionRequest(Request request) {
//        if (request.body() instanceof FormBody)
//        {
//            FormBody body = (FormBody) request.body();
//            if (body.size() > 0) {
//                //封装参数
//                for (int i = 0; i < body.size(); i++) {
//                    Log.d(TAG, body.encodedName(i) + " >>>> " + body.encodedValue(i));
//                    Log.d(TAG, body.name(i) + " >>>> " + body.value(i));
//                    params.getP().add(body.encodedValue(i));
//                }
//            }
//        }
//
//        return request;
//    }


}