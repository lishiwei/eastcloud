package com.orientalfinance.eastcloud.utils;

/**
 * Created by lzy on 2017/6/14.
 * email:lizy@oriental-finance.com
 */

public class StringUtil {
    public static String replaceEmpty(String str) {
        return str.replaceAll(" ", "");
    }

    public static boolean isEmpty(String string) {
        if (string == null) {
            return true;
        }
        if (string.length() == 0) {
            return true;
        }
        return false;
    }
}
