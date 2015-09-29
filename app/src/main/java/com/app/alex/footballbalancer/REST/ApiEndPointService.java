package com.app.alex.footballbalancer.REST;


import com.app.alex.footballbalancer.dto.UserLoginObject;

import retrofit.http.GET;

/**
 * Created by alex on 9/25/15.
 */
public interface ApiEndPointService {

   String BASE_URL = "http://192.168.3.10:8080";

   @GET("/")
   retrofit.Call<UserLoginObject> getUser();

}
