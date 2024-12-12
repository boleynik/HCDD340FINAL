package edu.psu.ist.hcdd340.finalproject;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class suggestionsActivity extends AppCompatActivity {

    private String selectedMood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        // Retrieve the selected mood from the intent
        selectedMood = getIntent().getStringExtra("selectedMood");

        // Update content based on the selected mood
        updateContentBasedOnMood(selectedMood);
    }

    private void updateContentBasedOnMood(String mood) {
        TextView titleTextView = findViewById(R.id.app_title);
        ImageView imageView1 = findViewById(R.id.imageView_1);
        ImageView imageView2 = findViewById(R.id.imageView_2);

        switch (mood) {
            case "happy":
                titleTextView.setText("Happy Things for You!");
                // Set happy images or resources
                imageView1.setImageResource(R.drawable.happy_song);  // Placeholder resource
                imageView2.setImageResource(R.drawable.happy_gilmore_movie);  // Placeholder resource
                break;

            case "sad":
                titleTextView.setText("Sad Things for You!");
                // Set sad images or resources
                imageView1.setImageResource(R.drawable.sad_song);  // Placeholder resource
                imageView2.setImageResource(R.drawable.sad_movie);  // Placeholder resource
                break;

            case "angry":
                titleTextView.setText("Angry Things for You!");
                // Set angry images or resources
                imageView1.setImageResource(R.drawable.angry_song);  // Placeholder resource
                imageView2.setImageResource(R.drawable.angry_movie);  // Placeholder resource
                break;

            case "scared":
                titleTextView.setText("Scary Things for You!");
                // Set scared images or resources
                imageView1.setImageResource(R.drawable.scared_song);  // Placeholder resource
                imageView2.setImageResource(R.drawable.scared_movie);  // Placeholder resource
                break;

            case "excited":
                titleTextView.setText("Exciting Things for You!");
                // Set excited images or resources
                imageView1.setImageResource(R.drawable.excited_song);  // Placeholder resource
                imageView2.setImageResource(R.drawable.excited_movie);  // Placeholder resource
                break;

            case "bored":
                titleTextView.setText("Bored Things for You!");
                // Set bored images or resources
                imageView1.setImageResource(R.drawable.bored_song);  // Placeholder resource
                imageView2.setImageResource(R.drawable.bored_movie);  // Placeholder resource
                break;

            case "love":
                titleTextView.setText("Lovely Things for You!");
                // Set love images or resources
                imageView1.setImageResource(R.drawable.love_song);  // Placeholder resource
                imageView2.setImageResource(R.drawable.love_movie);  // Placeholder resource
                break;

            default:
                titleTextView.setText("Suggestions for You!");
                break;
        }
    }
}
