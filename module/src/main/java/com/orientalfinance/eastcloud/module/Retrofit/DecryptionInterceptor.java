package com.orientalfinance.eastcloud.module.Retrofit;

import android.util.Log;

import com.orientalfinance.eastcloud.module.core.ZipUtils;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 方法描述：OKHttp解密拦截器
 * Created by lzy on 2017/6/9.
 * email:lizy@oriental-finance.com
 */

public class DecryptionInterceptor implements Interceptor {
    private static final String TAG = DecryptionInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        return getDecryptionResponse(response);
    }


    private Response getDecryptionResponse(Response response) throws IOException {
        byte[] decryptBeforeBytes = response.body().bytes();
        Log.e(TAG, "Response解密前======》" + new String(decryptBeforeBytes, Charset.defaultCharset()));
        String decrypt = ZipUtils.gunzip(new String(decryptBeforeBytes));
        Log.e(TAG, "Response解密后======》" + decrypt);
        MediaType mediaType = response.body().contentType();
        if (decrypt == null) {
            return response;
        }
        ResponseBody responseBody = ResponseBody.create(mediaType, decrypt);
        return response.newBuilder().body(responseBody).build();
    }
}