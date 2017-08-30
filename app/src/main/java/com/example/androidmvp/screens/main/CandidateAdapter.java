package com.example.androidmvp.screens.main;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidmvp.R;
import com.example.androidmvp.data.Candidate;

import java.util.ArrayList;


public class CandidateAdapter extends RecyclerView.Adapter<CandidateAdapter.CandidateViewHolder> {

    private ArrayList<Candidate> candidateList;
    public CandidateAdapter(ArrayList<Candidate> candidateArrayList) {
        if (candidateArrayList != null) this.candidateList = candidateArrayList;
        else this.candidateList = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return candidateList == null ? 0 : candidateList.size();
    }

    @Override
    public CandidateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_candidate, parent, false);
        CandidateViewHolder myViewHolder = new CandidateViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final CandidateAdapter.CandidateViewHolder holder, final int listPosition) {
        holder.name.setText(candidateList.get(listPosition).getName());
        holder.votes.setText("" + candidateList.get(listPosition).getVotes());
    }

    public void updateList(ArrayList<Candidate> candidateArrayList) {
        if (this.candidateList != null) this.candidateList.clear();
        this.candidateList.addAll(candidateArrayList);
        notifyDataSetChanged();
    }

    static class CandidateViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, votes;
        public CandidateViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            votes = (TextView) itemView.findViewById(R.id.tv_votes);
        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + name.getText());
        }
    }

}
