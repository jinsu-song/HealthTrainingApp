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

public class FragmentThird extends Fragment {
    private int fragNumber;
    private ImageView iv3;
    private Button btnPlay3;

    public static FragmentThird newInstance(int fragNumber){
        FragmentThird  fragmentSThird = new FragmentThird ();
        Bundle bundle=new Bundle();
        bundle.putInt("fragNumber", fragNumber);
        fragmentSThird.setArguments(bundle);
        return fragmentSThird;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragNumber = getArguments().getInt("fragNumber",0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(R.layout.fragment03, container, false);

        return view;
    }

    // 이안에서 객체를 찾고 하고 싶은 event 처리를 다 하면 됨
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancdState){
        super.onViewCreated(view,savedInstancdState);
        btnPlay3 = (Button) view.findViewById(R.id.btnPlay3);

        iv3 = view.findViewById(R.id.iv3);

        iv3.setImageResource(R.drawable.decline);


           btnPlay3.setOnClickListener(new View.OnClickListener() {
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