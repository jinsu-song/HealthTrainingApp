package com.sample.healthtrainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button btnRegister, btnLogin;
    private EditText edtPassword, edtID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 Id 가져오기
        findViewByIdFunc();
        eventHandlerFunc();
    }   // end of onCreate

    private void eventHandlerFunc() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtID.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                Response.Listener<String> listener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jo = new JSONObject(response);
                            boolean success = jo.getBoolean("success");
                            Toast.makeText(MainActivity.this, success + "", Toast.LENGTH_SHORT).show();


                            if (success == true) {
                                String getId = jo.getString("id");
                                String getPassword = jo.getString("password");


                                if(id.equals(getId) && password.equals(getPassword)){
                                    Intent intent = new Intent(MainActivity.this, LoginSuccessActivity.class);
                                    Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                                    startActivity(intent);

                                }else{
                                    Toast.makeText(MainActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                                    Log.d("MainActivity","id, password not equals");

                                }
                            } else {
                                Toast.makeText(MainActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                                Log.d("MainActivity","id, password not equals 2");

                            }
                        } catch (JSONException jsone){
                            Log.d("MainActivity","Response error");
                        } catch (Exception e){
                            Log.d("MainActivity","Something error");
                        }
                    }   // end of onResponse
                };
                LoginRequest loginRequest = new LoginRequest(id,password,listener);
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                requestQueue.add(loginRequest);
            }   // end of onClick
        });
    }

    private void findViewByIdFunc() {
        edtID = findViewById(R.id.edtID);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
    }   // end of findViewByIdFunc
}