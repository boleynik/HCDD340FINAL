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
        bottomNavigation.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Toast.makeText(MoodLogActivity.this, "Home clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_moods:
                        Toast.makeText(MoodLogActivity.this, "Moods clicked", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MoodLogActivity.this, MoodLogActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.nav_profile:
                        Toast.makeText(MoodLogActivity.this, "Profile clicked", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });

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
