package com.sample.healthtrainingapp;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class MonthItemView extends AppCompatTextView {
    private MonthItem item;
    public MonthItemView(@NonNull Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
    }

    public MonthItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.WHITE);
    }

    public MonthItem getItem() {  return item; }

    public void setItem(MonthItem item) {
        this.item = item;
        int day = item.getDayValue();
        if(day != 0){
            this.setText(String.valueOf(day));
        }else{
            this.setText("");
        }
    }
}
