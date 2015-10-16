package com.app.alex.footballbalancer.Providers;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.app.alex.footballbalancer.MainActivity;
import com.app.alex.footballbalancer.R;
import com.app.alex.footballbalancer.REST.ApiEndPointService;
import com.app.alex.footballbalancer.Tools.Tools;
import com.app.alex.footballbalancer.dto.UserLoginObject;
import com.google.inject.Inject;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by alex on 10/16/15.
 */
public class AuthProvider {

    String TAG = "AuthProvider";

    Context context;

    @Inject
    public AuthProvider(Context context) {
        this.context = context;
    }

    private ProgressDialog progress;
    private ApiEndPointService service;
    private ArrayList<UserLoginObject> objects;

    public static CookieManager cookieManager;

    public ApiEndPointService get(){
        if (cookieManager == null) {
            cookieManager = new CookieManager();
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
            CookieHandler.setDefault(cookieManager);
        }

        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                List<HttpCookie> httpCookies = cookieManager.getCookieStore().getCookies();
                for (HttpCookie cookie : httpCookies) {
                    String cookieValue = cookie.getValue();
                    request.newBuilder()
                            .addHeader("Accept", "application/json, text/plain, */*")
                            .addHeader("User-Agent", "FootballBalancer")
                            .addHeader("Set-Cookie", cookieValue);
                }
                return chain.proceed(request);
            }
        });

        Retrofit retrofit
                = new Retrofit.Builder()
                .baseUrl(ApiEndPointService.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ApiEndPointService.class);

        return service;
    }

    public void makeLoginRequest(String login, String password, final Activity activity) {
        Call<ArrayList<UserLoginObject>> loginRequest = service.attemptLogin(login, password);
        showProgressDialog();

        loginRequest.enqueue(new Callback<ArrayList<UserLoginObject>>() {
            @Override
            public void onResponse(retrofit.Response<ArrayList<UserLoginObject>> response) {
                progress.dismiss();
                objects = response.body();
                openMainActivity();
                activity.finish();
            }

            public void openMainActivity() {
                Intent intent = new Intent(activity, MainActivity.class);
                intent.putExtra("UserLoginObject", objects);
                activity.startActivity(intent);
            }

            @Override
            public void onFailure(Throwable t) {
                progress.dismiss();
                Log.d(TAG, t.toString());
                Tools.makeToast(context, context.getString(R.string.bed_credentials));
            }
        });
    }

    public void showProgressDialog() {
        progress = new ProgressDialog(context);
        progress.setTitle(R.string.loading);
        progress.setMessage("Wait while loading…");
        progress.show();
    }
}
