package com.huatec.edu.mobileshop.http.presenter;

import com.huatec.edu.mobileshop.entity.MemberEntity;
import com.huatec.edu.mobileshop.http.HttpMethods;

import rx.Observable;
import rx.Subscriber;

public class MemberPresenter extends HttpMethods {

    public static  void register(Subscriber<MemberEntity> subscriber,String username,String email,String passward){
        Observable observable = memberService.register(username,passward,email)
                .map(new HttpResultFunc<MemberEntity>());
    }

    public static void login(Subscriber<MemberEntity> subscriber,String username,String passward){
        Observable observable = memberService.login(username,passward)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribe(observable,subscriber);
    }
}
