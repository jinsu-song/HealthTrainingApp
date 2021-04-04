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

public class Fragment10 extends Fragment {
    private int fragNumber;
    private ImageView iv10;
    private Button btn10;

    public static Fragment10 newInstance(int fragNumber){
        Fragment10 fragment10 = new Fragment10();
        Bundle bundle=new Bundle();
        bundle.putInt("fragNumber", fragNumber);
        fragment10.setArguments(bundle);
        return fragment10;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragNumber = getArguments().getInt("fragNumber",0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(R.layout.fragment10, container, false);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancdState){
        super.onViewCreated(view,savedInstancdState);
        btn10 = (Button) view.findViewById(R.id.btn10);

        iv10 = view.findViewById(R.id.iv10);


        iv10.setImageResource(R.drawable.protein);

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://whitepen.co.kr/%EB%8B%A8%EB%B0%B1%EC%A7%88-%EB%B3%B4%EC%B6%A9%EC%A0%9C-%EC%B6%94%EC%B2%9C/");
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