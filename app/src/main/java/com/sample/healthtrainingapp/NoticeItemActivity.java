package com.sample.healthtrainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class NoticeItemActivity extends AppCompatActivity {

    private NoticeData noticeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_item);
        Intent intent = getIntent();
        intent.getSerializableExtra("noticeData");
    }   // end of onCreate
}