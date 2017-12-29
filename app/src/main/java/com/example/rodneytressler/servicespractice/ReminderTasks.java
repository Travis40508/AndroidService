package com.example.rodneytressler.servicespractice;

import android.content.Context;

/**
 * Created by rodneytressler on 12/29/17.
 */

public class ReminderTasks {
    //STEP FOUR - create our reminder tasks class that will set an action listener, and determine which method to run whenever that action is performed.

    public static final String ACTION_INCREMENT_CLICK_COUNT = "increment-click-count";

    public static void executeTask(Context context, String action) {
        if(ACTION_INCREMENT_CLICK_COUNT.equals(action)) {
            incrementClickCount(context);
        }
    }

    private static void incrementClickCount(Context context) {
        PreferencesUtilities.incrementClicksCount(context);
    }
}
