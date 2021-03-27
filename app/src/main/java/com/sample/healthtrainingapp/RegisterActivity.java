package com.sample.healthtrainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtRegisterName, edtRegisterID,edtRegisterPassword1,
    edtRegisterPassword2, edtRegisterPhone, edtRegisterAge, edtRegisterAddress;
    private Button btnIsUniqueID, buttonRegister;
    private RadioGroup rdoGroup;
    private static String gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 위젯 아이디 설정
        findViewByIdFunc();

        // 이벤트 처리
        eventHandlerFunc();
    }   // end of onCreate

    private void eventHandlerFunc() {

//        btnIsUniqueID.setOnClickListener(v->{
//            String id = edtRegisterID.getText().toString().trim();
//            Response.Listener<String> listener = new Response.Listener<String>() {
//                @Override
//                public void onResponse(String response) {
//                    JSONObject jo = new JSONObject();
//                    boolean success = jo.getBoolean("success");
//                    if (success == true){
//                        Toast.makeText(RegisterActivity.this, "중복된 아이디 입니다.", Toast.LENGTH_SHORT).show();
//                    } else{
//                        Toast.makeText(RegisterActivity.this, "사용할 수 있는 아이디 입니다.", Toast.LENGTH_SHORT).show();
//                    }
//                }   // end of onResponse
//            };
//        });

        rdoGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            String genderInListener =null;
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rdoMan: genderInListener = "남자";break;
                    case R.id.rdoWoman: genderInListener = "여자";break;
                }   // end of switch
                gender = genderInListener;

            }   // end of onCheckedChanged

        });

        buttonRegister.setOnClickListener(v->{
            String name = edtRegisterName.getText().toString().trim();
            String id = edtRegisterID.getText().toString().trim();

            String password1 = edtRegisterPassword1.getText().toString().trim();
            String password2 = edtRegisterPassword2.getText().toString().trim();

            String phone = edtRegisterPhone.getText().toString().trim();
            String age = edtRegisterAge.getText().toString().trim();
            String address = edtRegisterAddress.getText().toString().trim();
                Response.Listener<String> listener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jo = new JSONObject(response);
                            boolean success = jo.getBoolean("success");

                            if (success == true) {
                                Toast.makeText(RegisterActivity.this, "회원가입 성공!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginSuccessActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(RegisterActivity.this, "회원가입 실패", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException jsone){
                            Toast.makeText(RegisterActivity.this, "JSONException", Toast.LENGTH_SHORT).show();
                        }
                    }   // end of onResponse
                };
                RegisterRequest registerRequest = new RegisterRequest(id,password1,name,age,phone,gender,address,listener);
                RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);
                requestQueue.add(registerRequest);
        });
    }   // end of eventHandlerFunc

    private void findViewByIdFunc() {
        edtRegisterName = findViewById(R.id.edtRegisterName);
        edtRegisterID = findViewById(R.id.edtRegisterID);
        btnIsUniqueID = findViewById(R.id.btnIsUniqueID);
        edtRegisterPassword1 = findViewById(R.id.edtRegisterPassword1);
        edtRegisterPassword2 = findViewById(R.id.edtRegisterPassword2);
        rdoGroup = findViewById(R.id.rdoGroup);
        edtRegisterPhone = findViewById(R.id.edtRegisterPhone);
        edtRegisterAge = findViewById(R.id.edtRegisterAge);
        edtRegisterAddress = findViewById(R.id.edtRegisterAddress);
        buttonRegister = findViewById(R.id.buttonRegister);
    }   // end of findViewByIdFunc
}