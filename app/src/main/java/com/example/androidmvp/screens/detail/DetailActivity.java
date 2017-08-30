package com.example.androidmvp.screens.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.androidmvp.R;

public class DetailActivity extends AppCompatActivity implements DetailView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}
