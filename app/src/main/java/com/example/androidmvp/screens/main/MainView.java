package com.example.androidmvp.screens.main;

import com.example.androidmvp.data.Candidate;

import java.util.List;

public interface MainView {
    void displayNewWinners(List<Candidate> winners);
    void showProgressBar();
    void hideProgressBar();
    void disableButton();
    void enableButton();
}
