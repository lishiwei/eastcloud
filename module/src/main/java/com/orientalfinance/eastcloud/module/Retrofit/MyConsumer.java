package com.orientalfinance.eastcloud.module.Retrofit;

import android.util.Log;
import android.widget.Toast;

import com.orientalfinance.eastcloud.module.ModuleContext;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/6/15.
 */

public abstract class MyConsumer<T> implements Consumer<T> {
    static String TAG = MyConsumer.class.getSimpleName();



    @Override
    public void accept(@NonNull T t) throws Exception {

        if (t instanceof SocketTimeoutException) {
            Log.e(TAG, t.toString());
            Toast.makeText(ModuleContext.getInstance().getModuleContext(), "网络连接超时!", Toast.LENGTH_SHORT).show();

        } else if (t instanceof ApiException) {
            Toast.makeText(ModuleContext.getInstance().getModuleContext(), ((ApiException) t).getMessage(), Toast.LENGTH_SHORT).show();
        } else if (t instanceof ConnectException) {
            Log.e(TAG, t.toString());
            Toast.makeText(ModuleContext.getInstance().getModuleContext(), "网络连接失败!", Toast.LENGTH_SHORT).show();
        }
        else {
            ((Exception)t).printStackTrace();
            Toast.makeText(ModuleContext.getInstance().getModuleContext(), "请求失败,请稍后重试!", Toast.LENGTH_SHORT).show();

        }
    }
}
