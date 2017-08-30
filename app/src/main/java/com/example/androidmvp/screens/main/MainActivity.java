package com.example.androidmvp.screens.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.androidmvp.R;
import com.example.androidmvp.data.Candidate;
import com.example.androidmvp.data.VoteUpdateService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    private static final int TOP_N = 3;
    private RecyclerView rvTopCandidates;
    private ProgressBar progressBar;
    private Button btnUpdate;

    private CandidateAdapter candidateAdapter;
    private MainPresenter mMainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvTopCandidates = (RecyclerView) findViewById(R.id.rv_candidates);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        btnUpdate = (Button) findViewById(R.id.btn_update);

        mMainPresenter = new MainPresenterImpl(this);

        initListView();
        initButton();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mMainPresenter.fetchNewWinners(TOP_N);
        startService(new Intent(getApplicationContext(), VoteUpdateService.class));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(getApplicationContext(), VoteUpdateService.class));
    }

    private void initListView() {
        candidateAdapter = new CandidateAdapter(null);
        rvTopCandidates.setLayoutManager(new LinearLayoutManager(this));
        rvTopCandidates.setItemAnimator(new DefaultItemAnimator());
        rvTopCandidates.setAdapter(candidateAdapter);
    }

    public void initButton() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainPresenter.fetchNewWinners(TOP_N);
            }
        });
    }



    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    public void disableButton() {
        btnUpdate.setEnabled(false);
    }

    public void enableButton() {
        btnUpdate.setEnabled(true);
    }

    public void displayNewWinners(List<Candidate> winners) {
        candidateAdapter.updateList((ArrayList<Candidate>) winners);
    }
}
