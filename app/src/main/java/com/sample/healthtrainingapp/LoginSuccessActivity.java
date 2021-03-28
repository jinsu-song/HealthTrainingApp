package com.sample.healthtrainingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/*
    로그인 또는 회원가입 성공시 나타나는 액티비티
 */
public class LoginSuccessActivity extends AppCompatActivity {
    private ImageButton ibOpenDrawable, ibCloseDrawable;
    private DrawerLayout drawerLayout;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        // 위젯 아이디 찾기
        findViewByIdFunc();

        // DrawerLayout 열고 닫기 이벤트
        openAndCloseDrawable();

    }   // end of onCreate

    private void openAndCloseDrawable() {
        ibOpenDrawable.setOnClickListener(v->{
            drawerLayout.openDrawer(linearLayout);
        });
        ibCloseDrawable.setOnClickListener(v->{
            drawerLayout.closeDrawer(linearLayout);
        });
    }   // end of openAndCloseDrawable

    private void findViewByIdFunc() {
        ibOpenDrawable = findViewById(R.id.ibOpenDrawable);
        ibCloseDrawable = findViewById(R.id.ibCloseDrawable);
        linearLayout = findViewById(R.id.linearLayout);
        drawerLayout = findViewById(R.id.drawerLayout);
    }   // end of findViewByIdFunc
}