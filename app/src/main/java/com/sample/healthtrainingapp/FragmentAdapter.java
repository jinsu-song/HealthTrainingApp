package com.sample.healthtrainingapp;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter  extends FragmentStateAdapter {
    //프래그먼트를 보여줄 개수 선정 50개 -> 4개
    private int count;

    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity, int count) {
        super(fragmentActivity);
        this.count = count;
    }

    //프래그먼트를 만들어서 제공해주는 함수
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = position % count;    // 4 % 4 (0 ~ 3)
        switch (index){
            case 0:  return  FragmentFirst.newInstance(index+1);
            case 1:  return  FragmentSecond.newInstance(index+1);
            case 2:  return  FragmentThird.newInstance(index+1);
            case 3:  return  FragmentFourth.newInstance(index+1);
            default: Log.e("FragmentAdapter:", "FragmentAdapter 에러발생");
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 200;
    }
}
