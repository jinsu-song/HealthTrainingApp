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
    private Button btnPlay11;

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

    // 이안에서 객체를 찾고 하고 싶은 event 처리를 다 하면 됨
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancdState){
        super.onViewCreated(view,savedInstancdState);
        btnPlay11 = (Button) view.findViewById(R.id.btnPlay11);

        iv11 = view.findViewById(R.id.iv11);


        iv11.setImageResource(R.drawable.bsn);


        btnPlay11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.coupang.com/np/search?q=BSN%20%EC%8B%A0%ED%83%80%20%ED%94%84%EB%A1%9C%ED%8B%B4%20%ED%8C%8C%EC%9A%B0%EB%8D%94&src=1139000&spec=10799999&addtag=200&ctag=BSN%20%EC%8B%A0%ED%83%80%20%ED%94%84%EB%A1%9C%ED%8B%B4%20%ED%8C%8C%EC%9A%B0%EB%8D%94&lptag=AF3252626&itime=20210404233138&pageType=SEARCH&pageValue=BSN%20%EC%8B%A0%ED%83%80%20%ED%94%84%EB%A1%9C%ED%8B%B4%20%ED%8C%8C%EC%9A%B0%EB%8D%94&wPcid=61401859963812587496947&wRef=&wTime=20210404233138&redirect=landing&traceid=V0-606-7f400c6da3304f50&subid=WHITEPEN&campaigntype=&placementid=&campaignid=&contentcategory=&contentkeyword=&imgsize=&pageid=&deviceid=&subparam=&contenttype=");
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