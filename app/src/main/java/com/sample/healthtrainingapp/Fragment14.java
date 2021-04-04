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
    private Button btnPlay14;

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

    // 이안에서 객체를 찾고 하고 싶은 event 처리를 다 하면 됨
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancdState){
        super.onViewCreated(view,savedInstancdState);
        btnPlay14 = (Button) view.findViewById(R.id.btnPlay14);

        iv14 = view.findViewById(R.id.iv14);


        iv14.setImageResource(R.drawable.perfect);


        btnPlay14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.coupang.com/np/search?q=%EC%B9%BC%EB%A1%9C%EB%B0%94%EC%9D%B4%20%ED%8D%BC%ED%8E%99%ED%8A%B8%20%ED%8C%8C%EC%9B%8C%EC%89%90%EC%9D%B4%ED%81%AC&src=1139000&spec=10799999&addtag=200&ctag=%EC%B9%BC%EB%A1%9C%EB%B0%94%EC%9D%B4%20%ED%8D%BC%ED%8E%99%ED%8A%B8%20%ED%8C%8C%EC%9B%8C%EC%89%90%EC%9D%B4%ED%81%AC&lptag=AF3252626&itime=20210405000142&pageType=SEARCH&pageValue=%EC%B9%BC%EB%A1%9C%EB%B0%94%EC%9D%B4%20%ED%8D%BC%ED%8E%99%ED%8A%B8%20%ED%8C%8C%EC%9B%8C%EC%89%90%EC%9D%B4%ED%81%AC&wPcid=61401859963812587496947&wRef=&wTime=20210405000142&redirect=landing&traceid=V0-606-acbcf172dab290a6&subid=WHITEPEN&campaigntype=&placementid=&campaignid=&contentcategory=&contentkeyword=&imgsize=&pageid=&deviceid=&subparam=&contenttype=");
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