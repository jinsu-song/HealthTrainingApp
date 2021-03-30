package com.sample.healthtrainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PT_ReservationActivity extends AppCompatActivity {
    private String id;
    private TrainerGridAdapter trainerGridAdapter;
    private GridView monthView, trainerGridView;
    private Button monthPrevious, monthNext;
    private TextView monthText;
    private MonthAdapter monthViewAdapter;
    private static ArrayList<TrainerData> trainerList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_t__reservation);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        findViewByIdFunc();
        eventHandlerFunc();

        trainerGridAdapter = new TrainerGridAdapter(PT_ReservationActivity.this,trainerList);
        trainerGridView.setAdapter(trainerGridAdapter);

        int curYear = monthViewAdapter.getCurYear();
        int curMonth = monthViewAdapter.getCurMonth();
        monthText.setText(curYear + "년 " + (curMonth + 1) + "월 ");


    }   // end of onCreate

    private void eventHandlerFunc() {
//        monthText.setOnClickListener(v->{
//            Toast.makeText(this, "왜안되샹", Toast.LENGTH_SHORT).show();
//            Response.Listener<String> listener = new Response.Listener<String>() {
//                String trainerName,trainerPosition,trainerCareer, picture;
//
//                @Override
//                public void onResponse(String response) {
//                    try{
//                        JSONObject jo = new JSONObject(response);
//                        JSONArray ja = jo.getJSONArray("webnautes");
//                        //boolean success = jo.getBoolean("success");
//
////                    if (success == true) {
////                        trainerName = jo.getString("trainerName");
////                        trainerPosition = jo.getString("trainerPosition");
////                        trainerCareer = jo.getString("trainerCareer");
////                        picture = jo.getString("picture");
//                        if (jo != null){
//
//                            Toast.makeText(PT_ReservationActivity.this, "jo null", Toast.LENGTH_SHORT).show();
//                        }
//                        for (int i = 0 ; i < ja.length();i++){
//                            JSONObject item = ja.getJSONObject(i);
//                            trainerName = item.getString("trainerName");
//                            trainerPosition = item.getString("trainerPosition");
//                            trainerCareer = item.getString("trainerCareer");
//                            picture = item.getString("picture");
//                            TrainerData trainerData = new TrainerData(trainerName,trainerPosition,trainerCareer,picture);
//                            trainerList.add(trainerData);
//                        }
////                    } else {
////                        Toast.makeText(PT_ReservationActivity.this, "가져오는데 실패", Toast.LENGTH_SHORT).show();
////                        Log.d("@@@@@@@@@@@@@@", "가져오는데 실패");
////                    }   // end of else
//                    } catch(JSONException jsone){
//                        Log.d("@@@@@@@@@@@@", "JSONException");
//                    }
//                }   // end of onResponse
//
//            };
//            TrainerRequest trainerRequest = new TrainerRequest(listener);
//            RequestQueue requestQueue = Volley.newRequestQueue(PT_ReservationActivity.this);
//            requestQueue.add(trainerRequest);
//        });
        String serverUrl = "http://songjinsu486.dothome.co.kr/project_php_files/GetTrainerProfileRequest.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST,serverUrl,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                trainerList.clear();
                trainerGridAdapter.notifyDataSetChanged();
                try{
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);
//                    String trainerName,trainerPosition,trainerCareer, picture;
                        String trainerName = jsonObject.getString("trainerName");
                        String trainerPosition = jsonObject.getString("trainerPosition");
                        String trainerCareer = jsonObject.getString("trainerCareer");
                        String picture = jsonObject.getString("picture");

                        trainerList.add(new TrainerData(trainerName, trainerPosition, trainerCareer, picture));
                    }   // end of for
                } catch(JSONException jsone){
                    jsone.printStackTrace();
                }
            }
        }, null);
        RequestQueue requestQueue = Volley.newRequestQueue(PT_ReservationActivity.this);
        requestQueue.add(jsonArrayRequest);




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
        trainerGridView = findViewById(R.id.gridView);
        monthViewAdapter = new MonthAdapter(this);
        monthView.setAdapter(monthViewAdapter);
    }   // end of findViewByIdFunc
}