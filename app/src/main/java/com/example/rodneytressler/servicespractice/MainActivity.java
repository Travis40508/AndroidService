package com.example.rodneytressler.servicespractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private TextView numberText;
    private Button incrementButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberText = findViewById(R.id.text_number);
        incrementButton = findViewById(R.id.button_increment);

        //STEP ONE - setup a shared pref that will listen for any change to its file. You'll have to implement onSharedPreferenceChangeListener in the class.
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.registerOnSharedPreferenceChangeListener(this);

        listenForButtonPress();

        setUpViewDefaults();
    }

    private void setUpViewDefaults() {
        if(PreferencesUtilities.getClicksCount(this) != 0) {
            int clickCount = PreferencesUtilities.getClicksCount(this);
            numberText.setText("Times Clicked: " + clickCount);
        } else {
            numberText.setText("Times Clicked: " + 0);
        }
    }

    @Override
    //STEP TWO - in the implemented method, tell the shared pref what to do whenever its value changes.
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        updateClickCount();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.unregisterOnSharedPreferenceChangeListener(this);
    }

    private void updateClickCount() {
        int clickCount = PreferencesUtilities.getClicksCount(this);
        numberText.setText("Times Clicked: " + clickCount);
    }

    //STEP SIX - start our service and pass in our action of choice for the service to pass to our task class to use our shared pref class, all off the main thread.
    public void listenForButtonPress() {
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntentService.class);
                intent.setAction(ReminderTasks.ACTION_INCREMENT_CLICK_COUNT);
                startService(intent);
            }
        });
    }
}
