package com.orientalfinance.eastcloud.module.Retrofit.encrypt;

import com.google.gson.Gson;
import com.orientalfinance.eastcloud.module.util.SignUtils;
import com.orientalfinance.eastcloud.module.util.ZipUtils;

/**
 * Created by lzy on 2017/6/9.
 * email:lizy@oriental-finance.com
 */

public class EncryptUtils {
    public static final String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAN3pSPZ5Mlry3ynH\n" +
            "Lkl+o1QlLFyCig/iadjuislQVsqc9QWZQVEJOa4Ve0IAYqAPx8nsNEaI9nQ04Zy1\n" +
            "UOH890Vi86F15EHefyW9pv5Th46eeaLEPTlScwUAYwd9c5pBZ+P7t9TVtjWvr5NO\n" +
            "gyKSkvZWhuGBs18+wy8rH1qJ5zs7AgMBAAECgYBeRjdLDp4H6VpJY2cUrgoxO0Gn\n" +
            "Y4XHzcZt9JldgRX+KcQmRr9q7+JjRJkCpys/GLUl4YUr2g/punWGn7jm6RMayjUn\n" +
            "iFQQwNtITSV5BCmClNQGvsbJlJqy6cWTzWFDd1rZO4r9d0T+NA26hMKkWt4qPJh1\n" +
            "2RtkIeYlOpReliiL4QJBAP+rJBFjXP6168iTwuRjUZdRNiYEpxw/4m7+jL2IBzO9\n" +
            "1JVv0EutN5mv0UYr/xx3zOgdkGy1bFpOfusSK3gInxMCQQDeMvCSGD94ffKVc676\n" +
            "h2ynUyDrZ+u4C5ohzPQ9fgCJ5pfKbauM03vlrA/oVP6996j0kxyoVeTw+fvE5pxC\n" +
            "/vA5AkEAkQVMgihweXJLegyGgfHsN/6yzkHZYGbEU91Di8Z6/1hwGwu/hQ2N+jkG\n" +
            "Zd1S6Zzyt779Swxll5vq1gAKdB2/zQJBAKOYZb9q0vBn6r9WmTIjmz/m2In5zXeI\n" +
            "M0dHm1va9ZKSkJed/3yECOiksmGgkp5TRbYsyiC2fQVfSJtEHzDEeyECQDvYwR7Y\n" +
            "NB7t3G3+VK5V5UnTSxrVgMzdh5ixQRTf8vgThwZnraQMYdP9kxbBh2fbQDYFzQw0\n" +
            "s+TR5KJo5aqSO5w=";

    public static String encrypt(Object requestData) {
        Gson gson = new Gson();
        String reqStr = gson.toJson(requestData);
        String s = ZipUtils.gzip(reqStr);
        //产生签名
        return SignUtils.sign(s, privateKey);
    }

    public static String getZip(Object requestData) {
        Gson gson = new Gson();
        String reqStr = gson.toJson(requestData);
        return ZipUtils.gzip(reqStr);
    }

}
