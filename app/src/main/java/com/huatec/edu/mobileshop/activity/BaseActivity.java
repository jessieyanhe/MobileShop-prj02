package com.huatec.edu.mobileshop.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.huatec.edu.mobileshop.R;

public class BaseActivity extends AppCompatActivity {

    //购物车商品数量
    private static int cartCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }


    //是否登录了
    public boolean isLogin(){
        SharedPreferences sharedPreferences = getSharedPreferences("user",0);
        return !TextUtils.isEmpty(sharedPreferences.getString("user",""));
    }

    //显示商品
    public void showGoods(int goodsid){
        Intent intent = new Intent(this,GoodsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.putExtra("goods_id",goodsid);
        startActivity(intent);
    }

    public static int getCartCount() {
        return cartCount;
    }

    public static void setCartCount(int cartCount) {
        BaseActivity.cartCount = cartCount;
    }
}
