package com.sample.healthtrainingapp;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.Calendar;

public class MonthAdapter extends BaseAdapter {
    private Context mContext;    //화면에 메인을 저장한다.
    private MonthItem[] items = new MonthItem[7*6];;   //여기에는 각뷰에 삽입될 데이타제공한다. (날짜)
    //================================================
    private  int curYear;
    private  int curMonth;
    private  int firstDay;
    private  int lastDay;

    private Calendar mCalendar;
    //=================================================

    //1. 생성자 화면에 보이기 위해서 두가지 생성자를 부른다.
    public MonthAdapter(Context mContext) {
        this.mContext = mContext;
        init();
    }
    public MonthAdapter(Context mContext, AttributeSet attributeSet) {
        this.mContext = mContext;
        init();
    }

    public int getCurYear() {
        return curYear;
    }

    public void setCurYear(int curYear) {
        this.curYear = curYear;
    }

    public int getCurMonth() {
        return curMonth;
    }

    public void setCurMonth(int curMonth) {
        this.curMonth = curMonth;
    }

    public void init() {
        //달력을 가져옵니다.
        mCalendar=Calendar.getInstance();
        //현재날짜 2021 3 9 화요일 -> 3월 1일로 셋팅한다.
        mCalendar.set(Calendar.DAY_OF_MONTH,1);
        // 3월 1일 무슨요일에 속하는지 - 월요일  Calendar.MONDAY
        // 3월 1일이 월요일때   firstDay = 1
        int dayOfWeek = mCalendar.get(Calendar.DAY_OF_WEEK);
        firstDay = getFirstDay(dayOfWeek);

        //3월 1일의   2021년도
        curYear = mCalendar.get(Calendar.YEAR);
        //3월 1일의 달  3월
        curMonth = mCalendar.get(Calendar.MONTH);
        //3월달의 마지막 일 -> 31일
        lastDay = getMonthLastDay(curYear, curMonth);

        //======================================================================
        // 42개 배열에  달력과 똑같이 구조를 잡기위한 포문
        for(int i=0; i < 42; i++){
            int dayNumber = (i+1)- firstDay;
            if(dayNumber < 1 || dayNumber > lastDay){
                dayNumber = 0;
            }
            items[i]  = new MonthItem(dayNumber);
        }
    }

    //버튼을 이전달로 선택했을때
    public void setPreviousMonth(){
        //현재달력이 3월 1일 셋팅이 되었다면 달력을 4월달로 다시 셋팅한다.
        mCalendar.add(Calendar.MONTH, -1);

        // 2월 1일 무슨요일에 속하는지 - 월요일  Calendar.MONDAY
        // 2월 1일이 목요일때   firstDay = 1
        int dayOfWeek = mCalendar.get(Calendar.DAY_OF_WEEK);
        firstDay = getFirstDay(dayOfWeek);

        //2월 1일의   2021년도
        curYear = mCalendar.get(Calendar.YEAR);
        //2월 1일의 달  2월
        curMonth = mCalendar.get(Calendar.MONTH);
        //2월달의 마지막 일 -> 28일
        lastDay = getMonthLastDay(curYear, curMonth);
        //======================================================================
        // 42개 배열에  달력과 똑같이 구조를 잡기위한 포문
        for(int i=0; i < 42; i++){
            int dayNumber = (i+1)- firstDay;
            if(dayNumber < 1 || dayNumber > lastDay){
                dayNumber = 0;
            }
            items[i]  = new MonthItem(dayNumber);
        }
    }

    //버튼을 이전달로 선택했을때
    public void setNextMonth(){
        //현재달력이 3월 1일 셋팅이 되었다면 달력을 4월달로 다시 셋팅한다.
        mCalendar.add(Calendar.MONTH, 1);

        // 4월 1일 무슨요일에 속하는지 - 월요일  Calendar.MONDAY
        // 4월 1일이 목요일때   firstDay = 4
        int dayOfWeek = mCalendar.get(Calendar.DAY_OF_WEEK);
        firstDay = getFirstDay(dayOfWeek);

        //4월 1일의   2021년도
        curYear = mCalendar.get(Calendar.YEAR);
        //4월 1일의 달  4월
        curMonth = mCalendar.get(Calendar.MONTH);
        //4월달의 마지막 일 -> 30일
        lastDay = getMonthLastDay(curYear, curMonth);
        //======================================================================
        // 42개 배열에  달력과 똑같이 구조를 잡기위한 포문
        for(int i=0; i < 42; i++){
            int dayNumber = (i+1)- firstDay;
            if(dayNumber < 1 || dayNumber > lastDay){
                dayNumber = 0;
            }
            items[i]  = new MonthItem(dayNumber);
        }
    }

    //3월 1일 월요일이었을때 1값을 리턴한다.
    public int getFirstDay(int dayOfWeek){
        int result =0;
        switch (dayOfWeek){
            case Calendar.SUNDAY : result =0; break;
            case Calendar.MONDAY : result =1; break;
            case Calendar.TUESDAY : result =2; break;
            case Calendar.WEDNESDAY : result =3; break;
            case Calendar.THURSDAY : result =4; break;
            case Calendar.FRIDAY : result =5; break;
            case Calendar.SATURDAY : result =6; break;
        }
        return result;
    }

    //현재월의 마지막 날짜를 계산해서 리턴한다.
    public int getMonthLastDay(int y, int m) {
        int number =0;
        switch (m){
            case 0: case 2:  case 4: case 6: case 7:  case 9: case 11: number = 31; break;
            case 3: case 5:  case 8: case 10: number = 30; break;
            case 1: number=((y%4==0)&&(y%100!=0)||(y%400 ==0)) ? (29) : (28); break;
        }
        return number;
    }

    //==================================================================

    @Override
    public int getCount() {
        return 42;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //화면에 보열줄 View 선언한다.
        MonthItemView itemView;
        //view 값이 널이면 만들고 널이 아니면 그 이전것을 사용한다.
        if(view == null){
            itemView = new MonthItemView(mContext);
        }else{
            itemView =(MonthItemView) view;
        }

        //뷰의 레이아웃을 결정한다. (폭과 높이 layoutWidth, layoutHight)
        GridView.LayoutParams params = new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT,120);
        //그리뷰의 42  6행 7열로 구성되어 있다.   i = 37번이라면  rowIndex = 37 / 7 ->5행
        int rowIndex = i / 7;
        int columnIndex = i %  7;

        //뷰에 들어갈 글자를 넣어준다.
        itemView.setItem(items[i]);
        itemView.setLayoutParams(params);
        itemView.setPadding(2,2,2,2);

        //뷰에 해당되는 부모위치를 정한다.
        itemView.setGravity(Gravity.LEFT);

        //일요일이면 텍스트 색상을 빨간색으로 하고 나머지는 블랙하겠다. 툐요일은 파란색
        switch (columnIndex){
            case 0: itemView.setTextColor(Color.RED);
            case 6: itemView.setTextColor(Color.BLUE);
            default: itemView.setTextColor(Color.BLACK);
        }

        return itemView;
    }
}
