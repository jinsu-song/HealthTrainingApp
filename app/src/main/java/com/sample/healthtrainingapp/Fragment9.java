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

public class Fragment9 extends Fragment {
    private int fragNumber;
    private ImageView iv9;
    private Button btn9;

    public static Fragment9 newInstance(int fragNumber){
        Fragment9 fragment9 = new Fragment9();
        Bundle bundle=new Bundle();
        bundle.putInt("fragNumber", fragNumber);
        fragment9.setArguments(bundle);
        return fragment9;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragNumber = getArguments().getInt("fragNumber",0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(R.layout.fragment09, container, false);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancdState){
        super.onViewCreated(view,savedInstancdState);
        btn9 = (Button) view.findViewById(R.id.btn9);

        iv9 = view.findViewById(R.id.iv9);


        iv9.setImageResource(R.drawable.salad);


        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://healthtalkmentaltalk.tistory.com/198");
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