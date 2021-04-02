package com.sample.healthtrainingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
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

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class PT_ReservationActivity extends AppCompatActivity {
    private String id;
    private TrainerGridAdapter trainerGridAdapter;
    private GridView trainerGridView;
    private CalendarView calendarView;
    private Date date = new Date();
    public static final long TIME_CASTING_TO_LONG_10DAYS = 864000000L;
    private static ArrayList<TrainerData> trainerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_t__reservation);

        // 현재 사용자의 id 가져오기
        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        // 위젯 ID 찾기
        findViewByIdFunc();

        // 이벤트 처리
        eventHandlerFunc();

        trainerGridAdapter = new TrainerGridAdapter(PT_ReservationActivity.this,trainerList);
        trainerGridView.setAdapter(trainerGridAdapter);


    }   // end of onCreate

    private void eventHandlerFunc() {

        String serverUrl = "http://songjinsu486.dothome.co.kr/project_php_files/GetTrainerProfileRequest.php";

        // JsonArray값을 받아올 것이므로 JSONObject가 아닌 JsonArrayRequest이다.
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST,serverUrl,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                trainerList.clear();
                trainerGridAdapter.notifyDataSetChanged();
                try{
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);
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

        trainerGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }   // end of onItemClick
        });

        calendarView.setMaxDate(getMaxDateToLong());
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(PT_ReservationActivity.this, dayOfMonth+"", Toast.LENGTH_SHORT).show();
            }
        });


    }   // end of eventHandlerFunc

    private Long getMaxDateToLong(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        String strCurrentDay = calendar.get(Calendar.YEAR) +"-"+
                (calendar.get(Calendar.MONTH)+1)+"-" +calendar.get(Calendar.DATE);
        Date currentDay = dateFormat.parse(strCurrentDay,new ParsePosition(0));
        Long currentTimeLong = currentDay.getTime();

        return currentTimeLong + TIME_CASTING_TO_LONG_10DAYS;
    }

    private void findViewByIdFunc() {
        calendarView = findViewById(R.id.calendarView);
        trainerGridView = findViewById(R.id.gridView);
    }   // end of findViewByIdFunc
}