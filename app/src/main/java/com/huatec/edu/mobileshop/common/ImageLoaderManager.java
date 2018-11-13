package com.huatec.edu.mobileshop.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;

import com.huatec.edu.mobileshop.R;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

public class ImageLoaderManager {

    private static ImageLoaderManager mInstance;
    public static ImageLoaderManager getInstance(){
        if(mInstance == null){
            synchronized (ImageLoaderManager.class){
                if(mInstance == null){
                    mInstance = new ImageLoaderManager();
                }
            }
        }
        return mInstance;
    }

    public ImageLoaderManager(){
        if(mInstance == null){
            ImageLoader.getInstance().init(customImageLoaderConfig(MyApplication.getContext()));
        }
    }

    private ImageLoaderConfiguration defaultImageLoaderConfig(){
        return ImageLoaderConfiguration.createDefault(MyApplication.getContext());
    }

    private ImageLoaderConfiguration customImageLoaderConfig(Context context){
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480,800)
                .memoryCache(new LruMemoryCache(2*1024*1024))
                .diskCacheSize(20*1024*1024)
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                .diskCacheExtraOptions(480,800,null)
                .threadPoolSize(3)
                .threadPriority(Thread.NORM_PRIORITY-2)
                .denyCacheImageMultipleSizesInMemory()
                .imageDownloader(new BaseImageDownloader(context))
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()).writeDebugLogs()
                .build();

        return config;
    }

    public static DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.drawable.image_loading)
            .showImageForEmptyUri(R.drawable.image_empty)
            .showImageOnFail(R.drawable.image_error)
            .resetViewBeforeLoading(false)
            .delayBeforeLoading(1000)
            .cacheInMemory(false)
            .cacheOnDisk(false)
            .considerExifParams(false)
            .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
            .bitmapConfig(Bitmap.Config.ARGB_8888)
            .displayer(new SimpleBitmapDisplayer())
            .handler(new Handler())
            .build();


    //Image-loader框架显示图片的配置参数
    public static DisplayImageOptions product_options = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.drawable.image_loading) // 设置图片下载期间显示的图片
            .showImageForEmptyUri(R.drawable.image_empty) // 设置图片Uri为空或是错误的时候显示的图片
            .showImageOnFail(R.drawable.image_error) // 设置图片加载或解码过程中发生错误显示的图片
            .resetViewBeforeLoading(false)  // default 设置图片在加载前是否重置、复位
            .delayBeforeLoading(1000)  // 下载前的延迟时间
            .cacheInMemory(false) // default  设置下载的图片是否缓存在内存中
            .cacheOnDisk(false) // default  设置下载的图片是否缓存在SD卡中
            .considerExifParams(false) // default
            .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default 设置图片以如何的编码方式显示
            .bitmapConfig(Bitmap.Config.ARGB_8888) // default 设置图片的解码类型
            .displayer(new SimpleBitmapDisplayer()) // default  还可以设置圆角图片new RoundedBitmapDisplayer(20)
            .handler(new Handler()) // default
            .build();
    public static DisplayImageOptions user_options = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.drawable.image_loading) // 设置图片下载期间显示的图片
            .showImageForEmptyUri(R.drawable.face_default) // 设置图片Uri为空或是错误的时候显示的图片
            .showImageOnFail(R.drawable.face_default) // 设置图片加载或解码过程中发生错误显示的图片
            .resetViewBeforeLoading(false)  // default 设置图片在加载前是否重置、复位
            .delayBeforeLoading(1000)  // 下载前的延迟时间
            .cacheInMemory(false) // default  设置下载的图片是否缓存在内存中
            .cacheOnDisk(false) // default  设置下载的图片是否缓存在SD卡中
            .considerExifParams(false) // default
            .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default 设置图片以如何的编码方式显示
            .bitmapConfig(Bitmap.Config.ARGB_8888) // default 设置图片的解码类型
            .displayer(new SimpleBitmapDisplayer()) // default  还可以设置圆角图片new RoundedBitmapDisplayer(20)
            .handler(new Handler()) // default
            .build();
}
