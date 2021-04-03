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
    private Button btn11Time,btn13Time,btn15Time,btn17Time,btnReservate;
    private Date date = new Date();
    public static final long TIME_CASTING_TO_LONG_10DAYS = 864000000L;
    private static ArrayList<TrainerData> trainerList = new ArrayList<>();
    private static ArrayList<ReservateData> reservatedDataList = new ArrayList<>();
    boolean flagVisibility = false;
    private static int trainerSeletedPosition = 0;
    private static String reservatedDates = "";
    private static String reservateTime = "";
    private static int s_Year, s_Month, s_DayOfMonth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_t__reservation);

        // 현재 사용자의 id 가져오기
        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        // 위젯 ID 찾기
        findViewByIdFunc();
        calendarView.setVisibility(View.INVISIBLE);

        // 예약 시간 설정하는 버튼 숨기기
        buttonVisibility(View.INVISIBLE);

        // 이벤트 처리
        eventHandlerFunc();

        // 그리드뷰 어댑터에 트레이너 정보를 셋팅하고 그리드뷰와 어댑터를 연결
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

                // 트레이너 클릭시 달력이 보이게 또는 안보이게 셋팅
                calendarVisible_OR_Invisible();

                // 트레이너의 포지션을 저장
                trainerSeletedPosition = position;

                // 예약 시간 설정하는 버튼 숨기기
                buttonVisibility(View.INVISIBLE);

            }   // end of onItemClick
        });

        // 달력에 최대 예약날짜를 셋팅함
        calendarView.setMaxDate(getMaxDateToLong());

        // 달력에 최소 예약날짜를 정함
        calendarView.setMinDate(getMinDateToLong());

        final String TIME11 = "11:00";
        final String TIME13 = "13:00";
        final String TIME15 = "15:00";
        final String TIME17 = "17:00";
        // 달력의 날짜를 누를 때 이벤트 처리
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                s_Year = year;
                s_Month = month;
                s_DayOfMonth = dayOfMonth;
                reservatedDataList.clear();

                Response.Listener<String> listener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jo = new JSONObject(response);
                            reservatedDates = jo.getString("pt_Reservated");

                            // 버튼이 보이게
                            buttonVisibility(View.VISIBLE);

                            btn11Time.setEnabled(true);
                            btn13Time.setEnabled(true);
                            btn15Time.setEnabled(true);
                            btn17Time.setEnabled(true);

                            reservateTime = "";
                            String delims = ",";
                            String splitDate = reservatedDates;

                            if (reservatedDates.length() != 0) {
                                StringTokenizer st = new StringTokenizer(splitDate, delims);
                                reservatedDataList.clear();


                                while (st.hasMoreElements()) {
                                    reservatedDataList.add(new ReservateData(String.valueOf(st.nextElement())));
                                }   // end of while


                                for (int i = 0; i < reservatedDataList.size(); i++) {

                                    if (reservatedDataList.get(i).getYear() == s_Year && reservatedDataList.get(i).getMonth() == (s_Month + 1) &&
                                            reservatedDataList.get(i).getDayOfMonth() == s_DayOfMonth) {
                                        switch (reservatedDataList.get(i).getTime()) {

                                            case TIME11:btn11Time.setEnabled(false); break;
                                            case TIME13:btn13Time.setEnabled(false); break;
                                            case TIME15:btn15Time.setEnabled(false); break;
                                            case TIME17:btn17Time.setEnabled(false); break;

                                        }   // end of switch
                                    }
                                }   // end of for
                            } else{
                            }
                            reservateTime = s_Year + "/" + (s_Month + 1) + "/" + s_DayOfMonth;

                        } catch (JSONException jsone){
                            Log.d("PT_ReservationActivity", "calendarView JSONObject error");
                        }
                    }   // end of onResponse
                };  // end of Rosponse.Listener
                PT_ReservatedRequest pt_reservatedRequest =
                        new PT_ReservatedRequest(trainerList.get(trainerSeletedPosition).getTrainerName(), listener);
                RequestQueue requestQueue = Volley.newRequestQueue(PT_ReservationActivity.this);
                requestQueue.add(pt_reservatedRequest);

            }   // end of onSelectedDayChange
        });

        btn11Time.setOnClickListener(v->{
            if (reservatedDates.length() != 0){
                reservateTime = reservatedDates + "," + reservateTime + ("/" + TIME11);
            }else{
                reservateTime = reservateTime + ("/" + TIME11);
            }
            btnReservate.setEnabled(true);

        });

        btn13Time.setOnClickListener(v->{
            if (reservatedDates.length() != 0) {
                reservateTime = reservatedDates + "," + reservateTime + ("/" + TIME13);
            } else{
                reservateTime = reservateTime + ("/" + TIME13);

            }
            btnReservate.setEnabled(true);

        });

        btn15Time.setOnClickListener(v->{
            if (reservatedDates.length() != 0) {
                reservateTime = reservatedDates + "," + reservateTime + ("/" + TIME15);
            }else{
                reservateTime = reservateTime + ("/" + TIME15);
            }
            btnReservate.setEnabled(true);

        });

        btn17Time.setOnClickListener(v->{
            if (reservatedDates.length() != 0) {
                reservateTime = reservatedDates + "," + reservateTime + ("/" + TIME17);
            } else{
                reservateTime = reservateTime + ("/" + TIME17);
            }
            btnReservate.setEnabled(true);

        });

        btnReservate.setOnClickListener(v->{
            Response.Listener<String> listenerReservate= new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try{
                        JSONObject jo = new JSONObject(response);
                        boolean success = jo.getBoolean("success");

                        if (success == true) {
                            Toast.makeText(PT_ReservationActivity.this, "예약되었습니다.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(PT_ReservationActivity.this,LoginSuccessActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(PT_ReservationActivity.this, "예약 실패", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException jsone){
                        Log.d("PT_ReservationActivity","UPDATE Error At btnReservate");
                    }

                }   // end of onResponse
            };  // end of Response.Listener
            PT_ReservateUpdateRequest pt_reservateUpdateRequest =
                    new PT_ReservateUpdateRequest(trainerList.get(trainerSeletedPosition).getTrainerName(), reservateTime, listenerReservate);
            RequestQueue requestQueueUpdateTime = Volley.newRequestQueue(PT_ReservationActivity.this);
            requestQueueUpdateTime.add(pt_reservateUpdateRequest);
        });



    }   // end of eventHandlerFunc

    // 예약 시간을 설정하는 버튼을 보이게 또는 안보이게
    private void buttonVisibility(int visibleORInvisible) {
        btn11Time.setVisibility(visibleORInvisible);
        btn13Time.setVisibility(visibleORInvisible);
        btn15Time.setVisibility(visibleORInvisible);
        btn17Time.setVisibility(visibleORInvisible);
        btnReservate.setVisibility(visibleORInvisible);
        btnReservate.setEnabled(false);
    }   // end of buttonVisibility

    // 트레이너 클릭시 달력이 보이게 또는 안보이게 셋팅
    private void calendarVisible_OR_Invisible(){
        if (flagVisibility == false) {
            calendarView.setVisibility(View.VISIBLE);
            flagVisibility = true;
        } else{
            calendarView.setVisibility(View.INVISIBLE);
            flagVisibility = false;
        }
    }   // end of calendarVisible_OR_Invisible

    public static ArrayList<ReservateData> getReservatedDataList(){
        return PT_ReservationActivity.reservatedDataList;
    }   // end of getReservatedDataList

    // 달력에 최소 예약날짜를 셋팅함
    private long getMinDateToLong() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        String strNextDay = calendar.get(Calendar.YEAR) +"-"+
                (calendar.get(Calendar.MONTH)+1)+"-" +(calendar.get(Calendar.DATE) + 1);
        Date nextDay = dateFormat.parse(strNextDay,new ParsePosition(0));
        Long nextDayLong = nextDay.getTime();

        return nextDayLong;
    }   // end of getMinDateToLong

    // 달력에 최대 예약날짜를 셋팅함
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
        btn11Time = findViewById(R.id.btn11Time);
        btn13Time = findViewById(R.id.btn13Time);
        btn15Time = findViewById(R.id.btn15Time);
        btn17Time = findViewById(R.id.btn17Time);
        btnReservate = findViewById(R.id.btnReservate);
    }   // end of findViewByIdFunc
}