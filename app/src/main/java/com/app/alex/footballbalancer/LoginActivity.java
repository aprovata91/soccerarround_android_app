package com.app.alex.footballbalancer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.alex.footballbalancer.REST.ApiEndPointService;
import com.app.alex.footballbalancer.dto.UserLoginObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.util.Observable;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

/**
 * Created by alex on 8/18/15.
 */
@ContentView(R.layout.activity_login)
public class LoginActivity extends RoboActivity {

    public static final String BASE_URL = "http://192.168.3.10:8080/";

    @InjectView(R.id.login)
    private EditText mLoginEditText;
    @InjectView (R.id.password)
    private EditText mPasswordEditText;
    @InjectView(R.id.sign_in_button)
    private Button mLoginBtn;
    @InjectView(R.id.login_form)
    private View mLoginForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient okHttpClient = new OkHttpClient();

                Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                        .client(okHttpClient)
                        .build();

                final ApiEndPointService service = retrofit.create(ApiEndPointService.class);

                String object = service.getUser();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
