package com.sample.healthtrainingapp;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter3 extends FragmentStateAdapter {
    //프래그먼트를 보여줄 개수 선정 50개 -> 4개
    private int count;
    private int fragNumber;

    public FragmentAdapter3(@NonNull FragmentActivity fragmentActivity, int count, int fragNumber) {
        super(fragmentActivity);
        this.count = count;
    }

    //프래그먼트를 만들어서 제공해주는 함수
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = position % count;    // 4 % 4 (0 ~ 3)
        switch (index){
            case 0:  return  Fragment10.newInstance(index+1);
            case 1:  return  Fragment11.newInstance(index+1);
            case 2:  return  Fragment12.newInstance(index+1);
            case 3:  return  Fragment13.newInstance(index+1);
            case 4:  return  Fragment14.newInstance(index+1);
            default: Log.e("FragmentAdapter:", "FragmentAdapter 에러발생");
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 200;
    }
}

