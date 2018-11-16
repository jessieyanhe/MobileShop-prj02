package com.huatec.edu.mobileshop.common;

import com.huatec.edu.mobileshop.R;

public class Constants {
    /**
     * 广告显示时长 ，单位：ms
     */
    public static int AD_TIME_SECOND = 3000;
    /**
     * Base url
     */
    public static String BASE_URL = "http://192.168.1.71:8080/MobileShop/";
    /**
     * 广告url
     */
    //public static String AD_URL = BASE_URL + "";
    public static String AD_URL = "drawable://"+ R.drawable.sample_ad ;
    public static String API_KEY_FOR_MOB_SMS = "182489edf1060";
    public static String API_SECRET_FOR_MOB_SMS = "5955939eb23eb90c2baa227f87de43a0";

    /**
     * 列表页面右侧列表的列数
     */
    public static int SPAN_COUNT = 3;
}
