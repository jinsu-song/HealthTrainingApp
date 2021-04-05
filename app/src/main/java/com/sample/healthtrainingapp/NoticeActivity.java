package com.sample.healthtrainingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class NoticeActivity extends AppCompatActivity {
    private ArrayList<NoticeData> noticeDataList = new ArrayList<>();
    private NoticeRecyclerViewAdapter noticeRecyclerViewAdapter;
    private RecyclerView noticeRecyclerView;
    private Button btnWrite;
    private int position;

    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        // 뷰 아이디
        findViewByIdFunc();

        // 이벤트 처리
        eventHandlerFunc();
    }   // end of onCreate

    private void findViewByIdFunc() {
        noticeRecyclerView = findViewById(R.id.noticeRecyclerView);
//        btnWrite = findViewById(R.id.btnWrite);
    }   // end of findViewByIdFunc

    private void eventHandlerFunc() {
        String serverUrl = "http://songjinsu486.dothome.co.kr/project_php_files/NoticeRequest.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, serverUrl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                noticeDataList.clear();
                noticeRecyclerViewAdapter.notifyDataSetChanged();

                try{
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);
                        int no = jsonObject.getInt("no");
                        String title = jsonObject.getString("title");
                        String content = jsonObject.getString("content");
                        String author = jsonObject.getString("author");
                        String writeDate = jsonObject.getString("write_date");

                        noticeDataList.add(new NoticeData(no, title, content, author, writeDate));

                    }   // end of for
                } catch (JSONException jsone){
                    Log.d("NoticeActivity", "JSONException error at jsonArrayRequest");
                }
            };
        }, null);
        RequestQueue requestQueue = Volley.newRequestQueue(NoticeActivity.this);
        requestQueue.add(jsonArrayRequest);

        // 어댑터 참조변수에에 context와 item에 들어갈 noticeDataList를 매개로 생성자를 참조시킨다.
        noticeRecyclerViewAdapter = new NoticeRecyclerViewAdapter(NoticeActivity.this, noticeDataList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NoticeActivity.this);
        noticeRecyclerView.setLayoutManager(linearLayoutManager);
        noticeRecyclerView.setAdapter(noticeRecyclerViewAdapter);

        if (noticeRecyclerViewAdapter == null){
            Toast.makeText(this, "noticeRecyclerViewAdapter가 널임", Toast.LENGTH_SHORT).show();
        }else{
            noticeRecyclerViewAdapter.setOnItemClickListener(new NoticeRecyclerViewAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    setPosition(position);
                    Intent intent = new Intent(NoticeActivity.this, NoticeItemActivity.class);
                    intent.putExtra("noticeData",noticeDataList.get(position));
                    startActivity(intent);
                }
            });
        }



    }   // end of eventHandlerFunc
}