package com.app.alex.footballbalancer.REST;


import com.app.alex.footballbalancer.dto.UserLoginObject;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by alex on 9/25/15.
 */
public interface ApiEndPointService {

   String BASE_URL = "http://192.168.3.10:8080";

   @FormUrlEncoded
   @POST("/login")
   Call<ArrayList<UserLoginObject>> attemptLogin(@Field("username") String login, @Field("password") String password);
}
