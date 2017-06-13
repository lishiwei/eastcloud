package com.orientalfinance.eastcloud.module.Retrofit.log;

import android.text.TextUtils;
import android.util.Log;

import com.orientalfinance.eastcloud.module.util.ZipUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * 类描述：日志拦截器
 */
public class LogParamsInterceptor implements Interceptor {
    public static final String TAG = "OkHttpUtils";
    private HashMap<String, String> params;
    private String tag;
    private boolean showLog;

    public LogParamsInterceptor(HashMap<String, String> params, String tag, boolean showLog) {
        this.params = params;
        this.showLog = showLog;
        this.tag = tag;
    }

    private LogParamsInterceptor() {
    }


    public static class Builder {
        private String tag;
        private HashMap<String, String> params;
        private boolean showLog;

        public LogParamsInterceptor build() {
            return new LogParamsInterceptor(params, tag, showLog);
        }

        public Builder() {
            tag = TAG;
            params = new HashMap<>();
        }

        public Builder addParams(String key, String value) {
            params.put(key, value);
            return this;
        }

        public Builder addParams(HashMap<String, String> params) {
            this.params.putAll(params);
            return this;
        }

        public Builder showLog(boolean showLog) {
            this.showLog = showLog;
            return this;
        }

        public Builder tag(String tag) {
            if (!TextUtils.isEmpty(tag)) {
                this.tag = tag;
            }
            return this;
        }
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        addParams(request);
        if (showLog) {
            logForRequest(request);
        }
        Response response = chain.proceed(request);

        if (showLog) {
            return logForResponse(response);
        } else {
            return response;
        }
    }

    private void addParams(Request request) {
        if ("GET".equals(request.method())) {
            // TODO: 2016/8/17  get拼接
        } else if ("POST".equals(request.method())) {
            // TODO: 2016/8/17  post注入参数
        }
    }

    private Response logForResponse(Response responseOrigin) {
        Response response = null;
        try {
            response = getDecryptionResponse(responseOrigin);


            //===>response log
            Log.e(tag, "========response'log=======");
            Response.Builder builder = response.newBuilder();
            Response clone = builder.build();
            Log.e(tag, "url : " + clone.request().url());
            Log.e(tag, "code : " + clone.code());
            Log.e(tag, "protocol : " + clone.protocol());
            if (!TextUtils.isEmpty(clone.message())) {
                Log.e(tag, "message : " + clone.message());
            }

            ResponseBody body = clone.body();


            if (body != null) {
                MediaType mediaType = MediaType.parse("UTF-8");
                if (mediaType != null) {
                    Log.e(tag, "responseBody's contentType : " + mediaType.toString());
                    if (isText(mediaType)) {
                        String resp = body.string();
                        Log.e(tag, "responseBody's content : " + resp);

                        body = ResponseBody.create(mediaType, resp);
                        return response.newBuilder().body(body).build();
                    } else {
                        Log.e(tag, "responseBody's content : " + " maybe [file part] , too large too print , ignored!");
                    }
                }
            }

            Log.e(tag, "========response'log=======end");
        } catch (Exception e) {
            //            e.printStackTrace();
        }

        return response;
    }

    private void logForRequest(Request request) {
        try {
            String url = request.url().toString();
            Headers headers = request.headers();

            Log.e(tag, "========request'log=======");
            Log.e(tag, "method : " + request.method());
            Log.e(tag, "url : " + url);
            if (headers != null && headers.size() > 0) {
                Log.e(tag, "headers : " + headers.toString());
            }
            RequestBody requestBody = request.body();
            if (requestBody != null) {
                MediaType mediaType = requestBody.contentType();
                if (mediaType != null) {
                    Log.e(tag, "requestBody's contentType : " + mediaType.toString());
                    if (isText(mediaType)) {
                        Log.e(tag, "requestBody's content : " + bodyToString(request));
                    } else {
                        Log.e(tag, "requestBody's content : " + " maybe [file part] , too large too print , ignored!");
                    }
                }
            }
            Log.e(tag, "========request'log=======end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isText(MediaType mediaType) {
        if (mediaType.type() != null && mediaType.type().equals("text")) {
            return true;
        }
        if (mediaType.subtype() != null) {
            if (mediaType.subtype().equals("json") ||
                    mediaType.subtype().equals("xml") ||
                    mediaType.subtype().equals("html") ||
                    mediaType.subtype().equals("webviewhtml")
                    )
                return true;
        }
        return false;
    }

    private String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "something error when show requestBody.";
        }
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
