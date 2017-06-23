package com.orientalfinance.eastcloud.module.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.orientalfinance.eastcloud.module.ModuleContext;

/**
 * Created by lzy on 2017/6/10.
 * email:lizy@oriental-finance.com
 */

public class DeviceUtil {
    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public static String getVersion() {
        try {
            PackageManager manager = ModuleContext.getInstance().getModuleContext().getPackageManager();
            PackageInfo info = manager.getPackageInfo(ModuleContext.getInstance().getModuleContext().getPackageName(), 0);
            Log.e("TAG", "版本号:" + info.versionName);
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "0.0";
        }
    }

    /**
     * 方法描述：获取手机的IMEI号
     */
    public static String getDeviceId() {
        String deviceid;
        TelephonyManager tm;
        try {
            tm = (TelephonyManager) ModuleContext.getInstance().getModuleContext().getSystemService(Context.TELEPHONY_SERVICE);
            deviceid = tm.getDeviceId();
        } catch (Exception exception) {
           deviceid = null;
        }
        return deviceid ;
    }
}
