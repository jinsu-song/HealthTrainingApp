package com.sample.healthtrainingapp;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PT_ReservatedRequest extends StringRequest {
    public static final String URL = "http://songjinsu486.dothome.co.kr/project_php_files/PT_ReservatedRequest.php";
    private static Map<String,String> map;
    private String trainerName;

    public PT_ReservatedRequest(String trainerName, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        this.trainerName = trainerName;
        map = new HashMap<>();
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        map.put("trainerName", trainerName);
        return map;
    }
}
