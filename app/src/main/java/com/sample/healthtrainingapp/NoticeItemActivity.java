package com.sample.healthtrainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class NoticeItemActivity extends AppCompatActivity {

    private NoticeData noticeData;
    private TextView tvTitle, tvContent, tvWriteDate, tvAuthor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_item);

        Intent intent = getIntent();
        noticeData = (NoticeData) intent.getSerializableExtra("noticeData");

        findViewByIdFunc();

        tvTitle.setText("제목 : " + noticeData.getTitle());
        tvWriteDate.setText("작성일 : " + noticeData.getWriteDate());
        tvAuthor.setText("작성자 : 관리자");
        tvContent.setText(noticeData.getContent());

    }   // end of onCreate

    private void findViewByIdFunc() {
        tvTitle = findViewById(R.id.textViewTitle);
        tvContent = findViewById(R.id.textViewContent);
        tvAuthor = findViewById(R.id.textViewAuthor);
        tvWriteDate = findViewById(R.id.textViewWriteDate);
    }   // end of findViewByIdFunc
}