package com.sample.healthtrainingapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment5 extends Fragment {
    private int fragNumber;
    private ImageView iv5;
    private Button btn5;

    public static Fragment5 newInstance(int fragNumber){
        Fragment5 fragment5 = new Fragment5();
        Bundle bundle=new Bundle();
        bundle.putInt("fragNumber", fragNumber);
        fragment5.setArguments(bundle);
        return fragment5;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragNumber = getArguments().getInt("fragNumber",0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(R.layout.fragment05, container, false);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancdState){
        super.onViewCreated(view,savedInstancdState);
        btn5 = (Button) view.findViewById(R.id.btn5);

        iv5 = view.findViewById(R.id.iv5);


        iv5.setImageResource(R.drawable.oat);


        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://steptohealth.co.kr/8-reasons-why-you-need-to-eat-more-oat-meal/");
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