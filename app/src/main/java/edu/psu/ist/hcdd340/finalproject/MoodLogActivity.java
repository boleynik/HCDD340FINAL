package edu.psu.ist.hcdd340.finalproject;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
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

      //  moodRecyclerView = findViewById(R.id.moodRecyclerView);
      //  moodRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load data from SharedPreferences
        List<MoodLogEntry> moodLogEntries = loadMoodLogs();

        // Set up RecyclerView
     //   moodLogAdapter = new MoodLogAdapter(moodLogEntries);
      //  moodRecyclerView.setAdapter(moodLogAdapter);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);
        NavigationHelper.setupBottomNavigation(this, bottomNavigation);


        try {
            // Find views
            TextView currentMood = findViewById(R.id.current_mood);
            TextView desiredMood = findViewById(R.id.desired_mood);
            TextView reason = findViewById(R.id.reason);
            ImageView imageView2 = findViewById(R.id.imageView2);

            if (currentMood == null || desiredMood == null || reason == null || imageView2 == null) {
                throw new NullPointerException("One or more views not found in layout");
            }

            // Set click listeners
            View.OnClickListener navigateToLogActivity = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MoodLogActivity.this, LogActivityActivity.class);
                    startActivity(intent);
                }
            };

            currentMood.setOnClickListener(navigateToLogActivity);
            desiredMood.setOnClickListener(navigateToLogActivity);
            reason.setOnClickListener(navigateToLogActivity);
            imageView2.setOnClickListener(navigateToLogActivity);

        } catch (Exception e) {
            Log.e(TAG, "Error initializing MoodLogActivity: " + e.getMessage());
        }
    }

    private List<MoodLogEntry> loadMoodLogs() {
        SharedPreferences sharedPreferences = getSharedPreferences("MoodTrackerPrefs", MODE_PRIVATE);
        List<MoodLogEntry> moodLogs = new ArrayList<>();

        // Retrieve the stored logs string
        String existingLogs = sharedPreferences.getString("moodLogs", "");

        // Split the logs into individual entries
        String[] logEntries = existingLogs.split("\n");

        for (String entry : logEntries) {
            // Parse each entry
            String[] parts = entry.split("\n");
            if (parts.length >= 4) {
                // Extract mood, desired mood, reason, and timestamp
                String currentMood = parts[0].replace("Current Mood: ", "");
                String desiredMood = parts[1].replace("Desired Mood: ", "");
                String reason = parts[2].replace("Reason: ", "");
                String timestamp = java.time.LocalDateTime.now().toString(); // You might want to save actual timestamp

                moodLogs.add(new MoodLogEntry(currentMood, reason, timestamp));
            }
        }

        return moodLogs;
    }

}
