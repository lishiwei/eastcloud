package com.orientalfinance.eastcloud.module;

import android.content.Context;

/**
 * Created by lzy on 2017/6/10.
 * email:lizy@oriental-finance.com
 */

public class ModuleContext {
    private static final Object objectLock = new Object();
    private static ModuleContext moduleContext;
    public Context mContext;

    private ModuleContext() {
    }

    public static ModuleContext getInstance() {
        if (moduleContext == null) {
            synchronized (objectLock) {
                if (moduleContext == null) {
                    moduleContext = new ModuleContext();
                }
            }
        }
        return moduleContext;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public Context getModuleContext() {
        return mContext;
    }
}
