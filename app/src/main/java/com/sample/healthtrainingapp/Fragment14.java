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

public class Fragment14 extends Fragment {
    private int fragNumber;
    private ImageView iv14;
    private Button btn14;

    public static Fragment14 newInstance(int fragNumber){
        Fragment14 fragment14 = new Fragment14();
        Bundle bundle=new Bundle();
        bundle.putInt("fragNumber", fragNumber);
        fragment14.setArguments(bundle);
        return fragment14;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragNumber = getArguments().getInt("fragNumber",0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(R.layout.fragment14, container, false);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancdState){
        super.onViewCreated(view,savedInstancdState);
        btn14 = (Button) view.findViewById(R.id.btn14);

        iv14 = view.findViewById(R.id.iv14);


        iv14.setImageResource(R.drawable.perfect);


        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://url.kr/3ijghw");
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