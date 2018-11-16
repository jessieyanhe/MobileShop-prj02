package com.huatec.edu.mobileshop.common;

import android.app.Application;
import android.content.Context;

import com.huatec.edu.mobileshop.db.GreenDaoManager;
import com.huatec.edu.mobileshop.http.HttpMethods;

public class MyApplication extends Application{
    public static Context mContext;
    public static Context getContext(){
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        GreenDaoManager.getInstance();
        HttpMethods.getInstance();
        ImageLoaderManager.getInstance();
    }
}
