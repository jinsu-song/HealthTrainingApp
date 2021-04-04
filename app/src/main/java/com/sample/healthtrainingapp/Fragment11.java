package com.sample.healthtrainingapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment11 extends Fragment {
    private int fragNumber;
    private ImageView iv11;
    private Button btn11;

    public static Fragment11 newInstance(int fragNumber){
        Fragment11 fragment11 = new Fragment11();
        Bundle bundle=new Bundle();
        bundle.putInt("fragNumber", fragNumber);
        fragment11.setArguments(bundle);
        return fragment11;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragNumber = getArguments().getInt("fragNumber",0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(R.layout.fragment11, container, false);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancdState){
        super.onViewCreated(view,savedInstancdState);
        btn11 = (Button) view.findViewById(R.id.btn11);

        iv11 = view.findViewById(R.id.iv11);


        iv11.setImageResource(R.drawable.bsn);


        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://url.kr/keoh43");
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