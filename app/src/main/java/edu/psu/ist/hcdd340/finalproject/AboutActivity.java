package edu.psu.ist.hcdd340.finalproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Set the title of the About page
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("About");
        }
    }
}
