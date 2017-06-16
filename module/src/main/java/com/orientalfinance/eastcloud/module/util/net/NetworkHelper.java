/**
 * 下午1:03:25
 */
package com.orientalfinance.eastcloud.module.util.net;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * 类描述：Android网络状态及相关操作的工具类
 * 作者：lzy on 2015/3/14
 */
public class NetworkHelper {
    public static final String IP_DEFAULT = "0.0.0.0";
    public static String ping;
    public static final int PING_SUCCESS = 0;
    public static final int PING_FAILE = 1;

    /**
     * 方法描述：获取ConnectivityManager实例
     */
    private static ConnectivityManager getConnectivityManager(Context context) {
        return (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    /**
     * 方法描述：判断网络是否连接
     */
    public static boolean isConnected(Context context) {
        ConnectivityManager connectivity = getConnectivityManager(context);

        if (null != connectivity) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (null != info && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 方法描述：判断是否是wifi连接
     */
    public static boolean isWifi(Context context) {
        return getConnectivityManager(context) != null &&
                getConnectivityManager(context).getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;
    }

    /**
     * 方法描述：判断当前网络是否移动网络
     */
    public static boolean isMobileNet(Context context) {
        ConnectivityManager connectivity = getConnectivityManager(context);
        NetworkInfo activeNetInfo = connectivity.getActiveNetworkInfo();
        return activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE;
    }

    /**
     * 方法描述：获取连接的网络类型
     */
    public static ConnectivityType getConnectedType(Context context) {
        NetworkInfo mNetworkInfo = getConnectivityManager(context)
                .getActiveNetworkInfo();
        if (null != mNetworkInfo) {
            switch (mNetworkInfo.getType()) {
                case ConnectivityManager.TYPE_WIFI:
                    return ConnectivityType.WIFI;
                case ConnectivityManager.TYPE_MOBILE:
                    return ConnectivityType.MOBILE;
                default:
                    return ConnectivityType.UNKNOWN;
            }
        }
        return ConnectivityType.OFFLINE;
    }

    /**
     * 方法描述：获取IP地址
     */
    public static String getIPAddress() {
        try {
            final Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface
                    .getNetworkInterfaces();

            while (networkInterfaceEnumeration.hasMoreElements()) {
                final NetworkInterface networkInterface = networkInterfaceEnumeration
                        .nextElement();

                final Enumeration<InetAddress> inetAddressEnumeration = networkInterface
                        .getInetAddresses();

                while (inetAddressEnumeration.hasMoreElements()) {
                    final InetAddress inetAddress = inetAddressEnumeration
                            .nextElement();

                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
            return NetworkHelper.IP_DEFAULT;
        } catch (final SocketException e) {
            return NetworkHelper.IP_DEFAULT;
        }
    }

    /**
     * 方法描述：wifi连接时判断当前WiFi是否可用
     *
     * @param ipString ip地址
     * @return success表示网络畅通，否则网络不通
     */
    public static int Ping(String ipString) {
        int result = -1;
        Process p;
        try {
            // ping -c 2 -w 100 中 ，-c 是指ping的次数 2是指ping 2次 ，-w 100
            // 以秒为单位指定超时间隔，是指超时时间为100秒
            p = Runtime.getRuntime().exec("ping -c 2 -w 100 " + ipString);
            int status = p.waitFor();

            InputStream input = p.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(input));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
            System.out.println("Return ============" + buffer.toString());

            if (status == 0) {
                result = PING_SUCCESS;
            } else {
                result = PING_FAILE;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 方法描述：打开网络设置界面
     *
     * @param activity 上下文
     */
    public static void openSetting(Activity activity) {
        Intent intent = new Intent("/");
        ComponentName cm = new ComponentName("com.android.settings",
                "com.android.settings.WirelessSettings");
        intent.setComponent(cm);
        intent.setAction("android.intent.action.VIEW");
        activity.startActivityForResult(intent, 0);
    }


    public static void setPing(String ping) {
        NetworkHelper.ping = ping;
    }

}
