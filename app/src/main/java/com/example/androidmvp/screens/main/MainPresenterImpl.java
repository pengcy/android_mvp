package com.example.androidmvp.screens.main;

import android.os.Handler;

import com.example.androidmvp.data.Candidate;
import com.example.androidmvp.data.DataStore;

import java.util.List;

public class MainPresenterImpl implements MainPresenter {
    private MainView mMainView;
    private Handler mHandler = new Handler();
    public MainPresenterImpl(MainView mainView) {
        this.mMainView = mainView;
    }

    @Override
    public void fetchNewWinners(final int n) {
        startFetchingData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                final List<Candidate> winners = DataStore.INSTANCE.getTopWinners(n);

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mMainView.displayNewWinners(winners);
                        afterFetchingData();
                    }
                });
            }
        }).start();
    }

    private void startFetchingData() {
        mMainView.showProgressBar();
        mMainView.disableButton();
    }

    private void afterFetchingData() {
        mMainView.hideProgressBar();
        mMainView.enableButton();
    }
}
