package com.orientalfinance.eastcloud.module.core;

import android.content.Context;
import android.util.Log;

import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.module.javabean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 29435 on 2017/6/13.
 */

public class AcacheUtil {
    Context mContext;
    private static final AcacheUtil ourInstance = new AcacheUtil();
    List<String> mStringList = new ArrayList<>();

    public static AcacheUtil getInstance() {
        return ourInstance;
    }

    ACache aCache;

    private AcacheUtil() {

    }

    public void init(Context context) {
        mContext = context;
        aCache = ACache.get(mContext);
    }

    public void putUser(User user) {

        aCache.put(Constant.USER, user);
    }

    public User getUser() {
        ACache aCache = ACache.get(mContext);
        return (User) aCache.getAsObject(Constant.USER);
    }

    public boolean isUserLogin() {
        return getUser() != null;
    }


    public void AddHistory(String history) {
        mStringList.add(history);
        String mString = "";
        for (String str : mStringList) {
            mString += str + ",";

        }
        aCache.put(Constant.SEARCHHISTORY, mString);
    }

    public List<String> getHistory() {
        String mCacheString = aCache.getAsString(Constant.SEARCHHISTORY);
        if (mCacheString ==null)
        {
            return new ArrayList<>();
        }
        String[] strs = mCacheString.split(",");
        ArrayList<String> mCacheArray = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            mCacheArray.add(strs[i]);

        }
        return mCacheArray;

    }
    public void putTokenRefreshTime(String time)
    {
        aCache.put(Constant.TOKENREFRESHTIME,time);
    }
    public String getTokenRefreshTime()
    {
      return  aCache.getAsString(Constant.TOKENREFRESHTIME) ;
    }
    public boolean getTokenRefreshEnable()
    {
        if (getTokenRefreshTime()==null)
        {
            return true;
        }
        Log.d("AcacheUtils",getTokenRefreshTime());



        Log.d("AcacheUtils",TimeUtils.getTimeSpanByNow(getTokenRefreshTime(),TimeConstants.MSEC)+"");
        return TimeUtils.getTimeSpanByNow(getTokenRefreshTime(),TimeConstants.MSEC) >= TimeConstants.DAY;
    }
}