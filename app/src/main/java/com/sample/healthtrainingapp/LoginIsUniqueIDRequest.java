package com.sample.healthtrainingapp;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginIsUniqueIDRequest extends StringRequest {
    public static final String URL = "http://songjinsu486.dothome.co.kr/project_php_files/LoginIsUniqueRequest.php";
    private String id;
    private Map<String,String> map;

    public LoginIsUniqueIDRequest(String id, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        this.id = id;
        map = new HashMap<>();
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        map.put("id",this.id);
        return map;
    }
}
