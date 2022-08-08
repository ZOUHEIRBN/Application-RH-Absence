package com.pepsi.rh.api;

public class Notification {

    private int count;

    public Notification(int count) {
        this.count = count;
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