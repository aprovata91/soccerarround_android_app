package com.app.alex.footballbalancer.REST;


import com.app.alex.footballbalancer.LoginActivity;



import retrofit.http.GET;

/**
 * Created by alex on 9/25/15.
 */
public interface ApiEndPointService {

   @GET(LoginActivity.BASE_URL)
   String getUser();

}
