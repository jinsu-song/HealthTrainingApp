package com.sample.healthtrainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class PT_ReservationActivity extends AppCompatActivity {
    private String id;
    private GridView monthView;
    private Button monthPrevious, monthNext;
    private TextView monthText;
    private MonthAdapter monthViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_t__reservation);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        findViewByIdFunc();
        eventHandlerFunc();
        int curYear = monthViewAdapter.getCurYear();
        int curMonth = monthViewAdapter.getCurMonth();
        monthText.setText(curYear + "년 " + (curMonth + 1) + "월 ");


    }   // end of onCreate

    private void eventHandlerFunc() {
        monthText.setOnClickListener(v->{
            Toast.makeText(this, "왜 안나와", Toast.LENGTH_SHORT).show();
        });

        // 이전달을 누르면 취해지는 액션
        monthPrevious.setOnClickListener(v->{
            monthViewAdapter.setPreviousMonth();
            monthViewAdapter.notifyDataSetChanged();    // 무효화 영역처리 요구한다.
            int curYear = monthViewAdapter.getCurYear();
            int curMonth = monthViewAdapter.getCurMonth();
            monthText.setText(curYear + "년 " + (curMonth + 1) + "월 ");
        });

        monthNext.setOnClickListener(v->{
            monthViewAdapter.setNextMonth();
            monthViewAdapter.notifyDataSetChanged();    // 무효화 영역처리 요구한다.
            int curYear = monthViewAdapter.getCurYear();
            int curMonth = monthViewAdapter.getCurMonth();
            monthText.setText(curYear + "년 " + (curMonth + 1) + "월 ");
        });

        // 달력에 해당 date를 누르는 이벤트 처리
        monthView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MonthItem curItem = (MonthItem)monthViewAdapter.getItem(position);
                Toast.makeText(getApplicationContext(),String.valueOf(curItem.getDayValue()), Toast.LENGTH_SHORT).show();
            }
        });
    }   // end of eventHandlerFunc

    private void findViewByIdFunc() {
        monthView = findViewById(R.id.monthView);
        monthPrevious = findViewById(R.id.monthPrevious);
        monthNext = findViewById(R.id.monthNext);
        monthText = findViewById(R.id.monthText);

        monthViewAdapter = new MonthAdapter(this);
        monthView.setAdapter(monthViewAdapter);
    }   // end of findViewByIdFunc
}