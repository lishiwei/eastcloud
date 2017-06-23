package com.orientalfinance.eastcloud.module.core;

import android.content.Context;

import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.module.javabean.User;

/**
 * Created by 29435 on 2017/6/13.
 */

public class AcacheUtil {
    Context mContext;
    private static final AcacheUtil ourInstance = new AcacheUtil();

   public static AcacheUtil getInstance() {
        return ourInstance;
    }

    private AcacheUtil() {

    }

    public void init(Context context) {
        mContext = context;
    }

    public void putUser(User user) {
        ACache aCache = ACache.get(mContext);
        aCache.put(Constant.USER, user);
    }

    public User getUser() {
        ACache aCache = ACache.get(mContext);
        return (User) aCache.getAsObject(Constant.USER);
    }
    public boolean isUserLogin()
    {
        return getUser()!=null;
    }
}
