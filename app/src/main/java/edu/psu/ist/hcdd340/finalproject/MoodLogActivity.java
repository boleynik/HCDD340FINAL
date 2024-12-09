package edu.psu.ist.hcdd340.finalproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
    }

    private void loadMoodLogs() {
        SharedPreferences sharedPreferences = getSharedPreferences("MoodTrackerPrefs", MODE_PRIVATE);
        String moodLogs = sharedPreferences.getString("moodLogs", ""); // Default to empty if none

        if (!moodLogs.isEmpty()) {
            String[] logs = moodLogs.split("\n"); // Assuming each log is separated by a newline
            for (String log : logs) {
                addLogToContainer(log);
            }
        }
    }

    private void addLogToContainer(String log) {
        TextView logView = new TextView(this);
        logView.setText(log);
        logView.setTextSize(16);
        logView.setPadding(8, 8, 8, 8);
        moodLogContainer.addView(logView);
    }
}
