package com.sample.healthtrainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
    static RequestQueue requestQueue;
    public static final int TYPE_WIFI = 1;
    public static final int TYPE_MOBILE = 2;
    public static final int TYPE_NOT_CONNECTED = 3;
    private static UserData userData = UserData.getInstance();

    public static UserData getUserData(){
        return MainActivity.userData;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 인터넷 연결유무 확인
        boolean internetState = getConnectivityStatus(this);
        if (internetState ==false){
            Toast.makeText(this, "인터넷 연결이 되어 있지 않습니다.", Toast.LENGTH_SHORT).show();
        }

        // 위젯 Id 가져오기
        findViewByIdFunc();

        // 이벤트 처리
        eventHandlerFunc();
    }   // end of onCreate

    // 인터넷 연결유무 확인
    public static boolean getConnectivityStatus(Context context){
        ConnectivityManager manager = (ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if(networkInfo != null){
            return true;
        }
        return false;
    }   // end of getConnectivityStatus

    private void eventHandlerFunc() {
        btnRegister.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
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
                                String getAuthority = jo.getString("authority");

                                userData.setUserId(getId);
                                userData.setUserPassword(getPassword);
                                userData.setUserAuthority(getAuthority);


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
                requestQueue = Volley.newRequestQueue(MainActivity.this);
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