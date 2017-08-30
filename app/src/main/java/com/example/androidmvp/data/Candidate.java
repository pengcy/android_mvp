package com.example.androidmvp.data;


import android.support.annotation.NonNull;

public class Candidate implements Comparable{
    private String name;
    private int votes;

    public Candidate(String name, int votes) {
        this.name = name;
        this.votes = votes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }

    public void addVote() {
        this.votes++;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        // descending order
        if (this.votes > ((Candidate)o).votes) {
            return -1;
        } else if (this.votes < ((Candidate)o).votes) {
            return 1;
        }
        return 0;
    }
}
