package com.sample.healthtrainingapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentEight extends Fragment {
    private int fragNumber;
    private ImageView iv8;
    private Button btnPlay8;

    public static FragmentEight newInstance(int fragNumber){
        FragmentEight fragmentEight = new FragmentEight ();
        Bundle bundle=new Bundle();
        bundle.putInt("fragNumber", fragNumber);
        fragmentEight.setArguments(bundle);
        return fragmentEight;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragNumber = getArguments().getInt("fragNumber",0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(R.layout.fragment08, container, false);

        return view;
    }

    // 이안에서 객체를 찾고 하고 싶은 event 처리를 다 하면 됨
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancdState){
        super.onViewCreated(view,savedInstancdState);
        btnPlay8 = (Button) view.findViewById(R.id.btnPlay8);

        iv8 = view.findViewById(R.id.iv8);


        iv8.setImageResource(R.drawable.grapefruit);


        btnPlay8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://steptohealth.co.kr/diet-with-grapefruit-juice-after-meal/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onStop() {
        super.onStop();
    }
}