package com.huatec.edu.mobileshop.http.service;

import com.huatec.edu.mobileshop.entity.HttpResult;
import com.huatec.edu.mobileshop.entity.MemberEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MemberService {
    @FormUrlEncoded
    @POST("member")
    io.reactivex.Observable<HttpResult<MemberEntity>> register(
            @Field("uname")String uname,
            @Field("passward")String passward,
            @Field("email")String email);

    @FormUrlEncoded
    @POST("member/login")
    io.reactivex.Observable<HttpResult<MemberEntity>> login(
            @Field("uname")String uname,
            @Field("passward")String passward);
}
