package com.sample.healthtrainingapp;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    public static final String URL = "http://songjinsu486.dothome.co.kr/project_php_files/InsertRequest.php";
    private String id,password,name,age,phone,gender,address;
    private Map<String,String> map;

    public RegisterRequest(String id, String password, String name, String age, String phone, String gender,
                           String address, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        map = new HashMap<>();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        map.put("id",this.id);
        map.put("password",this.password);
        map.put("name",this.name);
        map.put("age",this.age);
        map.put("phone",this.phone);
        map.put("gender",this.gender);
        map.put("address",this.address);
        return map;
    }

}
