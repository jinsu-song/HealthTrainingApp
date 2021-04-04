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

public class Fragment12 extends Fragment {
    private int fragNumber;
    private ImageView iv12;
    private Button btn12;

    public static Fragment12 newInstance(int fragNumber){
        Fragment12 fragment12 = new Fragment12();
        Bundle bundle=new Bundle();
        bundle.putInt("fragNumber", fragNumber);
        fragment12.setArguments(bundle);
        return fragment12;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragNumber = getArguments().getInt("fragNumber",0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(R.layout.fragment12, container, false);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancdState){
        super.onViewCreated(view,savedInstancdState);
        btn12 = (Button) view.findViewById(R.id.btn12);

        iv12 = view.findViewById(R.id.iv12);


        iv12.setImageResource(R.drawable.muscle);


        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://url.kr/m65zvj");
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