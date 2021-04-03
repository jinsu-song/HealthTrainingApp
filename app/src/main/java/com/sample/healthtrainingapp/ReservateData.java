package com.sample.healthtrainingapp;

import android.util.Log;

import java.util.StringTokenizer;

public class ReservateData {
    private String year;
    private String month;
    private String dayOfMonth;
    private String time;


    public ReservateData(String reservateDate){
        final int YEAR_NUM = 0;
        final int MONTH_NUM = 1;
        final int DAY_OF_MONTH_NUM = 2;
        final int TIME_NUM = 3;
        String delims="/";
        StringTokenizer st = new StringTokenizer(reservateDate,delims);
        int num = 0;

        while(st.hasMoreElements()){
            String element = String.valueOf(st.nextElement());
            switch (num){
                case YEAR_NUM: year = element; break;
                case MONTH_NUM: month = element; break;
                case DAY_OF_MONTH_NUM: dayOfMonth = element; break;
                case TIME_NUM: time = element; break;
            }
            num++;
        }   // end of while
    }

    public int getYear() {
        int returnYear = 0;
        try{
            returnYear = Integer.parseInt(year);
        }catch (NumberFormatException nfe){
            Log.d("ResrvateData","nfe 발생 at getYear()");
        }
        return returnYear;
    }
    public void setYear(String year) {
        this.year = year;
    }

    public int getMonth() {
        int returnMonth = 0;
        try{
            returnMonth =  Integer.parseInt(month);
        } catch (NumberFormatException nfe){
            Log.d("ResrvateData","nfe 발생 at getMonth()");
        }
        return returnMonth;
    }
    public void setMonth(String month) {
        this.month = month;
    }

    public int getDayOfMonth() {
        int returnGetDayOfMonth = 0;
        try{
            returnGetDayOfMonth =  Integer.parseInt(dayOfMonth);
        } catch (NumberFormatException nfe){
            Log.d("ResrvateData","nfe 발생 at getMonth()");
        }
        return returnGetDayOfMonth;
    }
    public void setDayOfMonth(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
}
