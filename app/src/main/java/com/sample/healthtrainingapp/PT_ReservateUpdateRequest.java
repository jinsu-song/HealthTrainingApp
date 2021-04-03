package com.sample.healthtrainingapp;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PT_ReservateUpdateRequest extends StringRequest {
    public static final String URL = "http://songjinsu486.dothome.co.kr/project_php_files/PT_ReservateUpdateRequest.php";
    private String trainerName;
    private String reservateTime;
    private Map<String,String> map;

    public PT_ReservateUpdateRequest(String trainerName, String reservateTime, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        this.trainerName = trainerName;
        this.reservateTime = reservateTime;
        map = new HashMap<>();
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        map.put("trainerName", this.trainerName);
        map.put("reservateTime", this.reservateTime);
        return map;
    }
}
