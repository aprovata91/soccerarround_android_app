package com.app.alex.footballbalancer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.alex.footballbalancer.REST.ApiEndPointService;
import com.app.alex.footballbalancer.dto.UserLoginObject;


import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

/**
 * Created by alex on 8/18/15.
 */
@ContentView(R.layout.activity_login)
public class LoginActivity extends RoboActivity {

    String TAG = "Login activity";

    private UserLoginObject object;

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
                configureRetrofitRequest();
            }
        });
    }

    public void configureRetrofitRequest(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiEndPointService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiEndPointService service = retrofit.create(ApiEndPointService.class);

        retrofit.Call<UserLoginObject> userInfo = service.getUser();
        final ProgressDialog progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.show();

        userInfo.enqueue(new Callback<UserLoginObject>() {
            @Override
            public void onResponse(Response<UserLoginObject> response) {
                progress.dismiss();
                int statusCode = response.code();
                object = response.body();
                Log.e("", object.toString());

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("UserLoginObject", object);
                startActivity(intent);
            }

            @Override
            public void onFailure(Throwable t) {
                progress.dismiss();
                Log.d(TAG, t.toString());
            }
        });
    }
}
