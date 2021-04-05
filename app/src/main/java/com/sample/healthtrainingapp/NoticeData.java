package com.sample.healthtrainingapp;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class NoticeData implements Serializable {
    int no;
    private String title;
    private String content;
    private String author;
    private String writeDate;

    public NoticeData(int no, String title, String content, String author, String writeDate) {
        this.no = no;
        this.title = title;
        this.content = content;
        this.author = author;
        this.writeDate = writeDate;
    }

    public int getNo() {
        return no;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getWriteDate() {
        return writeDate;
    }
}
