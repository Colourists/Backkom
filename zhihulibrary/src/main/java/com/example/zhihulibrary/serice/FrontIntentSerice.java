package com.example.zhihulibrary.serice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

public class FrontIntentSerice extends IntentService {
    public static final String TAG = "FrontSerice";
    public boolean is = false;
    int i = 5;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public FrontIntentSerice(String name) {
        super(name);
        Log.e(TAG, "FrontIntentSerice: " + i);

    }

    public FrontIntentSerice() {
        super("intenr");
        Log.e(TAG, "FrontIntentSerice:  intenr " + i);

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        i = 5;
        is = true;
        post();
    }

    private void post() {
        i--;
        Log.e(TAG, "onStartCommand: " + System.currentTimeMillis());
        if (is) {
            try {
                Thread.sleep(1000);
                post();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        is = false;
        Log.e(TAG, "onDestroy: ");

    }
}
