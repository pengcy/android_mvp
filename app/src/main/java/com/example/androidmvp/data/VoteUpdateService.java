package com.example.androidmvp.data;


import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

public class VoteUpdateService extends Service {
    private static final int UPDATE_INTERVAL = 2000;
    private Handler mHandler = new Handler();
    private Runnable addVotes = new Runnable() {
        @Override
        public void run() {
            DataStore.INSTANCE.addRandomVotes();
            mHandler.postDelayed(addVotes, UPDATE_INTERVAL);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        addVotes.run();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
