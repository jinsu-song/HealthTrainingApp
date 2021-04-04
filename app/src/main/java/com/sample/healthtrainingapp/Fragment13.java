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

public class Fragment13 extends Fragment {
    private int fragNumber;
    private ImageView iv13;
    private Button btnPlay13;

    public static Fragment13 newInstance(int fragNumber){
        Fragment13 fragment13 = new Fragment13();
        Bundle bundle=new Bundle();
        bundle.putInt("fragNumber", fragNumber);
        fragment13.setArguments(bundle);
        return fragment13;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragNumber = getArguments().getInt("fragNumber",0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(R.layout.fragment13, container, false);

        return view;
    }

    // 이안에서 객체를 찾고 하고 싶은 event 처리를 다 하면 됨
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancdState){
        super.onViewCreated(view,savedInstancdState);
        btnPlay13 = (Button) view.findViewById(R.id.btnPlay13);

        iv13 = view.findViewById(R.id.iv13);


        iv13.setImageResource(R.drawable.whey);


        btnPlay13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.coupang.com/np/search?q=%EC%98%B5%ED%8B%B0%EB%A9%88%EB%89%B4%ED%8A%B8%EB%A6%AC%EC%85%98%20%EA%B3%A8%EB%93%9C%20%EC%8A%A4%ED%83%A0%EB%8B%A4%EB%93%9C%20%EC%9B%A8%EC%9D%B4%20%ED%94%84%EB%A1%9C%ED%8B%B4&src=1139000&spec=10799999&addtag=200&ctag=%EC%98%B5%ED%8B%B0%EB%A9%88%EB%89%B4%ED%8A%B8%EB%A6%AC%EC%85%98%20%EA%B3%A8%EB%93%9C%20%EC%8A%A4%ED%83%A0%EB%8B%A4%EB%93%9C%20%EC%9B%A8%EC%9D%B4%20%ED%94%84%EB%A1%9C%ED%8B%B4&lptag=AF3252626&itime=20210404235854&pageType=SEARCH&pageValue=%EC%98%B5%ED%8B%B0%EB%A9%88%EB%89%B4%ED%8A%B8%EB%A6%AC%EC%85%98%20%EA%B3%A8%EB%93%9C%20%EC%8A%A4%ED%83%A0%EB%8B%A4%EB%93%9C%20%EC%9B%A8%EC%9D%B4%20%ED%94%84%EB%A1%9C%ED%8B%B4&wPcid=61401859963812587496947&wRef=&wTime=20210404235854&redirect=landing&traceid=V0-606-8fa5ad4ac3392584&subid=WHITEPEN&campaigntype=&placementid=&campaignid=&contentcategory=&contentkeyword=&imgsize=&pageid=&deviceid=&subparam=&contenttype=");
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