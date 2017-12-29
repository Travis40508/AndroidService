package com.example.rodneytressler.servicespractice;

import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by rodneytressler on 12/29/17.
 */

public class IntentService extends android.app.IntentService {

    //STEP FIVE - create our intent class that will run our task executor class method in the background, which will then use our shared pref util to save.
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public IntentService(String name) {
        super(name);
    }

    public IntentService() {
        super("INTENT SERVICE");

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String action = intent.getAction();
        ReminderTasks.executeTask(this, action);
    }
}
