package com.pepsi.rh.api;

import java.util.Date;

public class Notification {

    private int count;
    private String title;
    private String text;
    private String url;
    private Date timestamp;

    public Notification(int count) {
        this.count = count;
    }
    public Notification(String title, String text) {
        this.count = 1;
        this.title = title;
        this.text = text;
        this.setTimestamp(new Date());
    }

    public Notification(String title, String text, String url) {
        this.count = 1;
        this.title = title;
        this.text = text;
        this.url = url;
        this.setTimestamp(new Date());
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void increment() {
        this.count++;
    }
}