package com.app.alex.footballbalancer.REST;


import com.app.alex.footballbalancer.dto.SignInObject;
import com.app.alex.footballbalancer.dto.UserLoginObject;

import org.apache.commons.lang.ObjectUtils;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by alex on 9/25/15.
 */
public interface ApiEndPointService {

   String BASE_URL = "http://192.168.3.10:8080";

   @FormUrlEncoded
   @POST("/login")
   Call<Void> attemptLogin(@Field("login") String login, @Field("pass") String password);

   @GET("/user")
   Call<UserLoginObject> getUser();

}
