package com.sample.healthtrainingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentFourth extends Fragment {
    private int fragNumber;
    private TextView tvName4;

    public static FragmentFourth newInstance(int fragNumber){
        FragmentFourth fragment = new FragmentFourth();
        Bundle bundle=new Bundle();
        bundle.putInt("fragNumber", fragNumber);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragNumber = getArguments().getInt("fragNumber",0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(
                R.layout.fragment04, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancdState){
        super.onViewCreated(view,savedInstancdState);
        tvName4 = (TextView) view.findViewById(R.id.tvName4);
        tvName4.setText("Page " + fragNumber);
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
