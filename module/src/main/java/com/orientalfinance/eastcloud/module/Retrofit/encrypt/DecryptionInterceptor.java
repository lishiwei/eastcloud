package com.orientalfinance.eastcloud.module.Retrofit.encrypt;

import android.util.Log;

import com.orientalfinance.eastcloud.module.util.ZipUtils;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
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
        Request request = chain.request();
        //  Request request1 = encryptRequest(request);
        Response response = chain.proceed(request);
        return getDecryptionResponse(response);
    }

    private Request encryptRequest(Request request) {
        FormBody body = (FormBody) request.body();
        FormBody.Builder newFormBuilder = new FormBody.Builder();
        if (body.size() > 0) {
            //封装参数
            for (int i = 0; i < body.size(); i++) {
                Log.e(TAG, body.encodedName(i) + " >>>> " + body.encodedValue(i));
                Log.e(TAG, body.name(i) + " >>>> " + body.value(i));
                switch (body.name(i)) {
                    case "s":
                        String zip = EncryptUtils.getZip( body.value(i));
                        newFormBuilder.add(body.name(i), zip);
                        break;
                    case "sign":
                        String encrypt = EncryptUtils.encrypt(body.value(i));
                        newFormBuilder.add(body.name(i), encrypt);
                        break;
                }

            }
        }


//        newFormBuilder.add("s","");
//        newFormBuilder.addEncoded(PARAMS_DATA, CryptUtil.enCryPto(params));
        Request.Builder builder = request.newBuilder();
        builder.url(request.url());
        builder.method(request.method(), newFormBuilder.build());
        return builder.build();
    }


    private Response getDecryptionResponse(Response response) throws IOException {
        byte[] decryptBeforeBytes = response.body().bytes();
        Log.e(TAG, "Response解密前======》" + new String(decryptBeforeBytes, Charset.defaultCharset()));
        String decrypt = ZipUtils.gunzip(new String(decryptBeforeBytes));
        Log.e(TAG, "Response解密后======》" + decrypt);
        MediaType mediaType = MediaType.parse("UTF-8");
        if (decrypt == null) {
            return response;
        }
        ResponseBody responseBody = ResponseBody.create(mediaType, decrypt);
        return response.newBuilder().body(responseBody).build();
    }
}