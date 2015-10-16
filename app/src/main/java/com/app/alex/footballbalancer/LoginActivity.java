package com.app.alex.footballbalancer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.alex.footballbalancer.Providers.AuthProvider;
import com.app.alex.footballbalancer.REST.ApiEndPointService;
import com.app.alex.footballbalancer.Tools.Tools;
import com.app.alex.footballbalancer.dto.UserLoginObject;
import com.google.inject.Inject;


import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
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

    @Inject
    AuthProvider authProvider;

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
                authProvider.get();
                authProvider.makeLoginRequest(mLoginEditText.getText().toString(),
                        mPasswordEditText.getText().toString(), LoginActivity.this);
            }
        });
    }
}
