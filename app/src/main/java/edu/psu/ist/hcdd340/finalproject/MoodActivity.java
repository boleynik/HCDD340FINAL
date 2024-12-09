package edu.psu.ist.hcdd340.finalproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.psu.ist.hcdd340.finalproject.R;

public class MoodActivity extends AppCompatActivity {

    // Emoji TextViews
    private TextView emojiHappy, emojiSad, emojiAngry, emojiScared, emojiExcited, emojiBored, emojiLove;
    private TextView emojiHappyTwo, emojiSadTwo, emojiAngryTwo, emojiScaredTwo, emojiExcitedTwo, emojiBoredTwo, emojiLoveTwo;

    // Other views
    private Spinner reasonSpinner;
    private EditText extraInput;
    private Button submitButton;

    // Selected emojis
    private String currentMood = "";
    private String desiredMood = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        // Initialize views
        initializeViews();

        // Set emoji click listeners
        setEmojiClickListeners();

        // Set submit button listener
        submitButton.setOnClickListener(v -> handleSubmit());
    }

    private void initializeViews() {
        emojiHappy = findViewById(R.id.emoji_happy);
        emojiSad = findViewById(R.id.emoji_sad);
        emojiAngry = findViewById(R.id.emoji_angry);
        emojiScared = findViewById(R.id.emoji_scared);
        emojiExcited = findViewById(R.id.emoji_excited);
        emojiBored = findViewById(R.id.emoji_bored);
        emojiLove = findViewById(R.id.emoji_love);

        emojiHappyTwo = findViewById(R.id.emoji_happy_two);
        emojiSadTwo = findViewById(R.id.emoji_sad_two);
        emojiAngryTwo = findViewById(R.id.emoji_angry_two);
        emojiScaredTwo = findViewById(R.id.emoji_scared_two);
        emojiExcitedTwo = findViewById(R.id.emoji_excited_two);
        emojiBoredTwo = findViewById(R.id.emoji_bored_two);
        emojiLoveTwo = findViewById(R.id.emoji_love_two);

        reasonSpinner = findViewById(R.id.reason_spinner);
        extraInput = findViewById(R.id.extra_input);
        submitButton = findViewById(R.id.submit_button);
    }

    private void setEmojiClickListeners() {
        View.OnClickListener moodClickListener = v -> {
            currentMood = ((TextView) v).getText().toString();
            showToast("Current mood selected: " + currentMood);
        };

        View.OnClickListener desiredMoodClickListener = v -> {
            desiredMood = ((TextView) v).getText().toString();
            showToast("Desired mood selected: " + desiredMood);
        };

        // Assign listeners for current mood
        emojiHappy.setOnClickListener(moodClickListener);
        emojiSad.setOnClickListener(moodClickListener);
        emojiAngry.setOnClickListener(moodClickListener);
        emojiScared.setOnClickListener(moodClickListener);
        emojiExcited.setOnClickListener(moodClickListener);
        emojiBored.setOnClickListener(moodClickListener);
        emojiLove.setOnClickListener(moodClickListener);

        // Assign listeners for desired mood
        emojiHappyTwo.setOnClickListener(desiredMoodClickListener);
        emojiSadTwo.setOnClickListener(desiredMoodClickListener);
        emojiAngryTwo.setOnClickListener(desiredMoodClickListener);
        emojiScaredTwo.setOnClickListener(desiredMoodClickListener);
        emojiExcitedTwo.setOnClickListener(desiredMoodClickListener);
        emojiBoredTwo.setOnClickListener(desiredMoodClickListener);
        emojiLoveTwo.setOnClickListener(desiredMoodClickListener);
    }

    private void handleSubmit() {
        String reason = reasonSpinner.getSelectedItem().toString();
        String extraMessage = extraInput.getText().toString();

        // Simple validation
        if (currentMood.isEmpty() || desiredMood.isEmpty()) {
            showToast("Please select both your current and desired mood.");
            return;
        }

        // Process the form submission
        String summary = "Current Mood: " + currentMood + "\n"
                + "Desired Mood: " + desiredMood + "\n"
                + "Reason: " + reason + "\n"
                + "Extra: " + extraMessage;

        // Save log entry to SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MoodTrackerPrefs", MODE_PRIVATE);
        String existingLogs = sharedPreferences.getString("moodLogs", "");
        sharedPreferences.edit().putString("moodLogs", existingLogs + summary + "\n").apply();

        showToast("Mood logged successfully!");

        // Display as a Toast (or handle as needed)
        showToast(summary);

        // Clear form fields
        extraInput.setText("");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}


