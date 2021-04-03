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

public class FragmentFourth extends Fragment {
    private int fragNumber;
    private ImageView iv4;
    private Button btnPlay4;

    public static FragmentFourth newInstance(int fragNumber){
        FragmentFourth  fragmentFourth = new FragmentFourth ();
        Bundle bundle=new Bundle();
        bundle.putInt("fragNumber", fragNumber);
        fragmentFourth.setArguments(bundle);
        return fragmentFourth;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragNumber = getArguments().getInt("fragNumber",0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(R.layout.fragment04, container, false);

        return view;
    }

    // 이안에서 객체를 찾고 하고 싶은 event 처리를 다 하면 됨
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancdState){
        super.onViewCreated(view,savedInstancdState);
        btnPlay4 = (Button) view.findViewById(R.id.btnPlay4);

        iv4 = view.findViewById(R.id.iv4);


        iv4.setImageResource(R.drawable.decline);


          btnPlay4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=AeDw1tlXczo");
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