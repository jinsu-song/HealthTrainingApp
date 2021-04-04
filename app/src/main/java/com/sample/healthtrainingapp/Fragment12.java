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
    private Button btnPlay12;

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

    // 이안에서 객체를 찾고 하고 싶은 event 처리를 다 하면 됨
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancdState){
        super.onViewCreated(view,savedInstancdState);
        btnPlay12 = (Button) view.findViewById(R.id.btnPlay12);

        iv12 = view.findViewById(R.id.iv12);


        iv12.setImageResource(R.drawable.muscle);


        btnPlay12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.coupang.com/vp/products/19977043?itemId=75678057&vendorItemId=3126494326&src=1139000&spec=10799999&addtag=400&ctag=19977043&lptag=AF3252626&itime=20210404235101&pageType=PRODUCT&pageValue=19977043&wPcid=61401859963812587496947&wRef=&wTime=20210404235101&redirect=landing&traceid=V0-606-f34f4e0d5783707c&placementid=&clickBeacon=&campaignid=&contentcategory=&imgsize=&pageid=&deviceid=&contenttype=&subid=WHITEPEN&impressionid=&campaigntype=&contentkeyword=&subparam=&isAddedCart=");
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