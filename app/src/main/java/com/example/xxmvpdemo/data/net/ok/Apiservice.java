package com.example.xxmvpdemo.data.net.ok;

import java.util.HashMap;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * author : xx
 * time : 2020/8/8 8:18
 * describe :
 **/
public interface Apiservice {
    @GET
    Observable<String> doGet(@Url String url, @QueryMap HashMap<String,Object> params, @HeaderMap HashMap<String,Object> headers);
    @POST
    @FormUrlEncoded
    Observable<String> doPost(@Url String url, @FieldMap HashMap<String,Object> params, @HeaderMap HashMap<String,Object> headers);
}
