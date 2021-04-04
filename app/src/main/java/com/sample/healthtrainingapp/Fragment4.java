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

public class Fragment4 extends Fragment {
    private int fragNumber;
    private ImageView iv4;
    private Button btn4;

    public static Fragment4 newInstance(int fragNumber){
        Fragment4 fragmentFourth = new Fragment4();
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


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancdState){
        super.onViewCreated(view,savedInstancdState);
        btn4 = (Button) view.findViewById(R.id.btn4);

        iv4 = view.findViewById(R.id.iv4);


        iv4.setImageResource(R.drawable.sit);


          btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse("https://www.youtube.com/watch?v=sTgMAZnlw44&list=PLTI10dby-phsSt78RhH0xKrFilfnjt5h9&index=11");
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