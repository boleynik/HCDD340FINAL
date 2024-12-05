package edu.psu.ist.hcdd340.finalproject;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private TextView tvLogNumber;
    private int logCount = 4; // Initial count

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        tvLogNumber = findViewById(R.id.tvLogNumber);
        Button btnLogMood = findViewById(R.id.btnLogMood);
        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);

        // Set button click listener
        btnLogMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logCount++; // Increment mood log count
                tvLogNumber.setText(logCount + " times! 🎉");
                Toast.makeText(MainActivity.this, "Mood logged successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle bottom navigation bar item clicks
        bottomNavigation.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Toast.makeText(MainActivity.this, "Home clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_moods:
                        Toast.makeText(MainActivity.this, "Moods clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_profile:
                        Toast.makeText(MainActivity.this, "Profile clicked", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });
    }
}
