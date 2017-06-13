package com.orientalfinance.eastcloud.module.util;

import android.util.Log;

import com.orientalfinance.eastcloud.module.BuildConfig;

/**
 * Created by lzy on 2017/6/13.
 * email:lizy@oriental-finance.com
 */

public class ModuleLog {
    public static boolean debug = BuildConfig.LOG_DEBUG;

    public static void e(String tag, String message) {
        if (debug) {
            Log.e(tag, message);
        }
    }

    public static void e(String message) {
        e("error", message);
    }

    public static void w(String tag, String message) {
        if (debug) {
            Log.w(tag, message);
        }
    }

    public static void w(String message) {
        w("warn", message);
    }

    public static void i(String tag, String message) {
        if (debug) {
            Log.i(tag, message);
        }
    }

    public static void i(String message) {
        i("info", message);
    }

    public static void d(String tag, String message) {
        if (debug) {
            Log.d(tag, message);
        }
    }

    public static void d(String message) {
        d("debug", message);
    }

    public static void v(String tag, String message) {
        if (debug) {
            Log.v(tag, message);
        }
    }

    public static void v(String message) {
        v("verbose", message);
    }
}
