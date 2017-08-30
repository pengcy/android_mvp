package com.example.androidmvp.data;

public class Vote {
    public long time;
    public String name;

    public Vote(String name, long time) {
        this.name = name;
        this.time = time;
    }
}