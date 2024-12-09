package edu.psu.ist.hcdd340.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MoodLogActivity extends AppCompatActivity {

    private LinearLayout moodLogContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_log);

        // Initialize the mood log container
        moodLogContainer = findViewById(R.id.moodLogContainer);

        // Load and display mood logs
        loadMoodLogs();

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);
        NavigationHelper.setupBottomNavigation(this, bottomNavigation);
    }



    private void loadMoodLogs() {
        moodLogContainer.removeAllViews(); // Clear existing logs

        SharedPreferences sharedPreferences = getSharedPreferences("MoodTrackerPrefs", MODE_PRIVATE);
        String moodLogs = sharedPreferences.getString("moodLogs", ""); // Default to empty if none

        if (!moodLogs.isEmpty()) {
            String[] logs = moodLogs.split("\n"); // Assuming each log is separated by a newline
            for (String log : logs) {
                if (!log.trim().isEmpty()) { // Skip any empty lines
                    addLogToContainer(log);
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadMoodLogs();
    }

    private void addLogToContainer(String log) {
        TextView logView = new TextView(this);
        logView.setText(log);
        logView.setTextSize(16);
        logView.setPadding(8, 8, 8, 8);
        moodLogContainer.addView(logView);
    }
}
