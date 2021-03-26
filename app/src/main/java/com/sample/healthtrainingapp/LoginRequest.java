package com.sample.healthtrainingapp;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    public static final String URL = "http://songjinsu486.dothome.co.kr/project_php_files/LoginRequest.php";
    private String id,password;
    private Map<String,String> map;

    public LoginRequest(String id, String password,Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        this.id = id;
        this.password = password;
        map = new HashMap<>();
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        map.put("id",this.id);
        map.put("password",this.password);
        return map;
    }
}
