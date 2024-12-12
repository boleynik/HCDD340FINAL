package edu.psu.ist.hcdd340.finalproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MoodLogActivity extends AppCompatActivity {

    private RecyclerView moodRecyclerView;
    private MoodLogAdapter moodLogAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_log);

        moodRecyclerView = findViewById(R.id.moodRecyclerView);
        moodRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load data from SharedPreferences
        List<MoodLogEntry> moodLogEntries = loadMoodLogs();

        // Set up RecyclerView
        moodRecyclerView = findViewById(R.id.moodRecyclerView);
        moodRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        moodLogAdapter = new MoodLogAdapter(this, moodLogEntries);
        moodRecyclerView.setAdapter(moodLogAdapter);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);
        NavigationHelper.setupBottomNavigation(this, bottomNavigation);
    }

    private List<MoodLogEntry> loadMoodLogs() {
        SharedPreferences sharedPreferences = getSharedPreferences("MoodTrackerPrefs", MODE_PRIVATE);
        List<MoodLogEntry> moodLogs = new ArrayList<>();

        // Retrieve the stored logs string
        String existingLogs = sharedPreferences.getString("moodLogs", "");

        // Split the logs into individual entries
        String[] logEntries = existingLogs.split("\n\n");

        for (String entry : logEntries) {
            // Parse each entry
            String[] parts = entry.split("\n");
            if (parts.length >= 3) {
                String currentMood = parts[0].replace("Current Mood: ", "");
                String desiredMood = parts[1].replace("Desired Mood: ", "");
                String reason = parts[2].replace("Reason: ", "");

                moodLogs.add(new MoodLogEntry(currentMood, desiredMood, reason));
            }
        }

        return moodLogs;
    }
}