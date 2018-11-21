package com.huatec.edu.mobileshop.http.service;

import com.huatec.edu.mobileshop.entity.HttpResult;
import com.huatec.edu.mobileshop.entity.MemberEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface MemberService {
    @FormUrlEncoded
    @POST("member")
    Observable<HttpResult<MemberEntity>> register(
            @Field("uname")String uname,
            @Field("passward")String passward,
            @Field("email")String email);

    @FormUrlEncoded
    @POST("member/login")
    Observable<HttpResult<MemberEntity>> login(
            @Field("uname")String uname,
            @Field("passward")String passward);

    @FormUrlEncoded
    @POST("member/{memberId")
    Observable<HttpResult<MemberEntity>> changePassword(
            @Field("memberId")String memberId,
            @Field("old_pwd")String old_pwd,
            @Field("new_pwd")String new_pwd);

    @FormUrlEncoded
    @POST("member/pwd")
    Observable<HttpResult<MemberEntity>> findPassword(
            @Field("email")String email);
}
