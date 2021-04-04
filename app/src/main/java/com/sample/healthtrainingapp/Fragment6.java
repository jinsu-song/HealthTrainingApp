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

public class Fragment6 extends Fragment {
    private int fragNumber;
    private ImageView iv6;
    private Button btn6;

    public static Fragment6 newInstance(int fragNumber){
        Fragment6 fragment6 = new Fragment6();
        Bundle bundle=new Bundle();
        bundle.putInt("fragNumber", fragNumber);
        fragment6.setArguments(bundle);
        return fragment6;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragNumber = getArguments().getInt("fragNumber",0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(R.layout.fragment06, container, false);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancdState){
        super.onViewCreated(view,savedInstancdState);
        btn6 = (Button) view.findViewById(R.id.btn6);

        iv6 = view.findViewById(R.id.iv6);


        iv6.setImageResource(R.drawable.cheese);


        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://steptohealth.co.kr/types-of-cheese-and-their-nutritional-value/");
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