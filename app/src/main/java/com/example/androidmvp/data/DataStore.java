package com.example.androidmvp.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public enum DataStore {
    INSTANCE;

    private List<Vote> votes = new ArrayList<>();
    private List<Candidate> candidates = new ArrayList<>();
    private DataStore() {
        this.votes = createVoteForAll();
        this.candidates = createCandidates(votes);
    }

    public List<Candidate> getTopWinners(int topK) {
        List<Candidate> topCandidates = new ArrayList<>();
        if (topK <= 0) return topCandidates;
        if (candidates.isEmpty()) return topCandidates;


        Collections.sort(candidates);

        for (int i=0; i<topK && i<candidates.size(); i++) {
            topCandidates.add(candidates.get(i));
        }

        return topCandidates;
    }

    public void addRandomVotes() {
        for (Candidate candidate : candidates) {
            int random = new Random().nextInt(100);
            for (int i=0; i<random; i++) {
                votes.add(new Vote(candidate.getName(), System.currentTimeMillis()));
                candidate.addVote();
            }
        }
    }

    private List<Vote> createVotes(String name, int n) {
        List<Vote> votes = new ArrayList<>();

        for (int i=0; i<n; i++) {
            votes.add(new Vote(name, System.currentTimeMillis()));
        }

        return votes;
    }

    private List<Candidate> createCandidates(List<Vote> votes) {
        List<Candidate> candidates = new ArrayList<>();
        if (votes == null) return candidates;


        HashMap<String, Integer> candidateVotes = new HashMap<>();

        for (int i=0; i<votes.size(); i++) {
            if (candidateVotes.containsKey(votes.get(i).name)) {
                int curCount = candidateVotes.get(votes.get(i).name);
                candidateVotes.put(votes.get(i).name, curCount + 1);
            } else {
                candidateVotes.put(votes.get(i).name, 1);
            }
        }

        for (Map.Entry entry : candidateVotes.entrySet()) {
            candidates.add(new Candidate((String)entry.getKey(), (int)entry.getValue()));
        }


        return candidates;
    }

    private List<Vote> createVoteForAll() {
        List<Vote> votesA = createVotes("Apple", 100);
        List<Vote> votesB = createVotes("Banana", 90);
        List<Vote> votesC = createVotes("Cherry", 80);
        List<Vote> votesD = createVotes("Durian", 70);
        List<Vote> votesE = createVotes("Eggfruit", 65);
        List<Vote> votesF = createVotes("Fig", 60);
        List<Vote> votesG = createVotes("Grapefruit", 55);
        List<Vote> votesH = createVotes("Honeydew", 50);
        List<Vote> votesI = createVotes("Ilama", 45);
        List<Vote> votesJ = createVotes("Jackfruit", 40);
        List<Vote> votesK = createVotes("Kiwi", 35);
        List<Vote> votesL = createVotes("Lime", 30);

        List<Vote> votes = new ArrayList<>();
        votes.addAll(votesA);
        votes.addAll(votesB);
        votes.addAll(votesC);
        votes.addAll(votesD);
        votes.addAll(votesE);
        votes.addAll(votesF);
        votes.addAll(votesG);
        votes.addAll(votesH);
        votes.addAll(votesI);
        votes.addAll(votesJ);
        votes.addAll(votesK);
        votes.addAll(votesL);
        return votes;
    }
}
