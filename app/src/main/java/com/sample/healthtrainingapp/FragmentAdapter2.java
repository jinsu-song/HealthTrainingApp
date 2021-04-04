package com.sample.healthtrainingapp;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter2 extends FragmentStateAdapter {
    private int count;
    private int fragNumber;

    public FragmentAdapter2(@NonNull FragmentActivity fragmentActivity, int count, int fragNumber) {
        super(fragmentActivity);
        this.count = count;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = position % count;    // 4 % 4 (0 ~ 3)
        switch (index){
            case 0:  return  Fragment5.newInstance(index+1);
            case 1:  return  Fragment6.newInstance(index+1);
            case 2:  return  Fragment7.newInstance(index+1);
            case 3:  return  Fragment8.newInstance(index+1);
            case 4:  return  Fragment9.newInstance(index+1);
            default: Log.e("FragmentAdapter:", "FragmentAdapter 에러발생");
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 200;
    }
}

