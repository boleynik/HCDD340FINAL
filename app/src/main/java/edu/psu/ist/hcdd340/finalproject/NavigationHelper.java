package edu.psu.ist.hcdd340.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationHelper {
    public static void setupBottomNavigation(final Activity activity, BottomNavigationView bottomNavigation) {
        bottomNavigation.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        if (!(activity instanceof MainActivity)) {
                            Intent homeIntent = new Intent(activity, MainActivity.class);
                            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            activity.startActivity(homeIntent);
                        }
                        return true;
                    case R.id.nav_moods:
                        if (!(activity instanceof MoodActivity)) {
                            Intent moodIntent = new Intent(activity, MoodActivity.class);
                            activity.startActivity(moodIntent);
                        }
                        return true;
                    case R.id.nav_profile:
                        if (!(activity instanceof MoodLogActivity)) {
                            Intent moodLogIntent = new Intent(activity, MoodLogActivity.class);
                            activity.startActivity(moodLogIntent);
                        }
                        return true;
                }
                return false;
            }
        });
    }
}

