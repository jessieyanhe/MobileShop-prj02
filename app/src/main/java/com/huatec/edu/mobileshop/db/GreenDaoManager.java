package com.huatec.edu.mobileshop.db;

import android.database.sqlite.SQLiteDatabase;

import com.huatec.edu.mobileshop.common.MyApplication;
import com.huatec.edu.mobileshop.gen.DaoMaster;
import com.huatec.edu.mobileshop.gen.DaoSession;

public class GreenDaoManager {

    private static GreenDaoManager mInstance;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;

    public GreenDaoManager(){
        if(mInstance == null){
            DaoMaster.DevOpenHelper devOpenHelper = new
                    DaoMaster.DevOpenHelper(MyApplication.getContext(),"mydb",null);
            SQLiteDatabase database = devOpenHelper.getWritableDatabase();
            mDaoMaster = new DaoMaster(database);
            mDaoSession = mDaoMaster.newSession();
        }
    }

    public static GreenDaoManager getInstance(){
        if(mInstance == null){
            synchronized (GreenDaoManager.class){
                if(mInstance == null){
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public static DaoMaster getMaster(){
        return  mDaoMaster;
    }

    public static DaoSession getSession(){
        return mDaoSession;
    }

    public  static DaoSession getNewSession(){
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }
}
