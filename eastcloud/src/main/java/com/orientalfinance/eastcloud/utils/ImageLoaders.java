package com.orientalfinance.eastcloud.utils;


import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.javabean.GlideCircleTransform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Timed;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;


/**
 * Created by 29435 on 2017/5/25.
 */

public class ImageLoaders {

    private static final String TAG = ImageLoaders.class.getSimpleName();

    public static void displayImage(ImageView imageView, String url) {
        try {
            Glide.with(imageView.getContext()).load(Integer.valueOf(url)).placeholder(R.drawable.loading).centerCrop().error(R.drawable.loaderror).into(imageView);
        } catch (Exception e) {
            Glide.with(imageView.getContext()).load(url).placeholder(R.drawable.loading).centerCrop().error(R.drawable.loaderror).into(imageView);

        }
    }

    public static void displayImage(ImageView imageView, Integer url) {
        Glide.with(imageView.getContext()).load(url).centerCrop().into(imageView);
    }

    public static void displayCircleImage(final ImageView imageView, String url) {
        Log.d(TAG, "displayCircleImage: ");
        try {
            Glide.with(imageView.getContext()).load(Integer.valueOf(url)).transform(new GlideCircleTransform(imageView.getContext())).centerCrop().error(R.drawable.loaderror).into(imageView);
        } catch (Exception e) {
            Glide.with(imageView.getContext()).load(url).transform(new GlideCircleTransform(imageView.getContext())).centerCrop().error(R.drawable.loaderror).into(imageView);

        }

    }

    static long time;

    private static class ProgressResponseBody extends ResponseBody {

        private final ResponseBody responseBody;
        private final ProgressListener progressListener;
        private BufferedSource bufferedSource;

        public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
            this.responseBody = responseBody;
            this.progressListener = progressListener;
        }

        @Override
        public MediaType contentType() {
            return responseBody.contentType();
        }

        @Override
        public long contentLength() {
            return responseBody.contentLength();
        }

        @Override
        public BufferedSource source() {
            if (bufferedSource == null) {
                bufferedSource = Okio.buffer(source(responseBody.source()));
            }
            return bufferedSource;
        }

        private Source source(Source source) {
            return new ForwardingSource(source) {
                long totalBytesRead = 0L;

                @Override
                public long read(Buffer sink, long byteCount) throws IOException {
                    long bytesRead = super.read(sink, byteCount);
                    // read() returns the number of bytes read, or -1 if this source is exhausted.
                    totalBytesRead += bytesRead != -1 ? bytesRead : 0;
                    progressListener.update(totalBytesRead, responseBody.contentLength(), bytesRead == -1);
                    return bytesRead;
                }
            };
        }
    }

    interface ProgressListener {
        void update(long bytesRead, long contentLength, boolean done);
    }

}


