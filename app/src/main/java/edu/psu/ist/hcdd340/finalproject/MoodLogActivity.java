package edu.psu.ist.hcdd340.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MoodLogActivity extends AppCompatActivity {

    private LinearLayout moodLogContainer;

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
        moodLogAdapter = new MoodLogAdapter(moodLogEntries);
        moodRecyclerView.setAdapter(moodLogAdapter);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);
        NavigationHelper.setupBottomNavigation(this, bottomNavigation);
    }



    private List<MoodLogEntry> loadMoodLogs() {
        SharedPreferences sharedPreferences = getSharedPreferences("MoodLog", MODE_PRIVATE);
        List<MoodLogEntry> moodLogs = new ArrayList<>();

        int logCount = sharedPreferences.getInt("logCount", 0);
        Log.d("MoodLogActivity", "Log count: " + logCount); // Debugging log

        for (int i = 0; i < logCount; i++) {
            String mood = sharedPreferences.getString("mood_" + i, null);
            String reason = sharedPreferences.getString("reason_" + i, null);
            String dateTime = sharedPreferences.getString("dateTime_" + i, null);

            if (mood != null && reason != null && dateTime != null) {
                moodLogs.add(new MoodLogEntry(mood, reason, dateTime));
            } else {
                Log.e("MoodLogActivity", "Error loading log for index: " + i);
            }
        }

        Log.d("MoodLogActivity", "Loaded logs: " + moodLogs.size());
        return moodLogs;
    }

}
