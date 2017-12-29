package com.example.rodneytressler.servicespractice;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by rodneytressler on 12/29/17.
 */

public class PreferencesUtilities {
    //STEP THREE - make your preference util class that will set the new count for prefs, get the count, and increment the count

    public static final String KEY_CLICK_COUNT = "click-count";
    public static final String KEY_CLICKING_REMINDER_COUNT = "clicking-reminder-count";

    private static final int DEFAULT_COUNT = 0;

    synchronized private static void setClickCount(Context context, int numberOfClicks) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_CLICK_COUNT, numberOfClicks);
        editor.apply();
    }

    public static int getClicksCount(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        int numberOfClicks = prefs.getInt(KEY_CLICK_COUNT, DEFAULT_COUNT);
        return numberOfClicks;
    }

    synchronized public static void incrementClicksCount(Context context) {
        int clicksCount = PreferencesUtilities.getClicksCount(context);
        PreferencesUtilities.setClickCount(context, ++clicksCount);
    }
}
