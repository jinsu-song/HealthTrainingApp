package com.sample.healthtrainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/*
    로그인 또는 회원가입 성공시 나타나는 액티비티
 */
public class LoginSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
    }   // end of onCreate
}