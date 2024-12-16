package edu.psu.ist.hcdd340.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;

public class MoodActivity extends AppCompatActivity {

    private Spinner moodActionSpinner;
    private TextView emojiHappy, emojiSad, emojiAngry, emojiScared, emojiExcited, emojiBored, emojiLove;
    private TextView emojiHappyTwo, emojiSadTwo, emojiAngryTwo, emojiScaredTwo, emojiExcitedTwo, emojiBoredTwo, emojiLoveTwo;
    private TextView feelText;
    private Spinner reasonSpinner;
    private EditText extraInput;
    private Button submitButton;
    private LinearLayout emojiLayout; // Layout for second set of emojis
    private String currentMood = "";
    private String desiredMood = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        // Initialize views
        initializeViews();

        // Set spinner listener to show second emoji set when "Change it" is selected
        moodActionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedAction = parentView.getItemAtPosition(position).toString();
                if (selectedAction.equals("Change it")) {
                    emojiLayout.setVisibility(View.VISIBLE); // Show second emoji set
                    feelText.setVisibility(View.VISIBLE); // Show text "How would you like to feel?"
                } else {
                    emojiLayout.setVisibility(View.GONE); // Hide second emoji set
                    feelText.setVisibility(View.GONE); // Hide the "How would you like to feel?" text
                    // If "Keep mood" is selected, set desiredMood to currentMood
                    if (selectedAction.equals("Keep mood")) {
                        desiredMood = currentMood;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing
            }
        });

        // Set emoji click listeners to display selected emoji in Snackbar
        setEmojiClickListeners();

        // Set up the submit button click listener
        submitButton.setOnClickListener(v -> handleSubmit());

        // Set up bottom navigation
        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);
        NavigationHelper.setupBottomNavigation(this, bottomNavigation);
    }

    private void initializeViews() {
        moodActionSpinner = findViewById(R.id.mood_action_spinner);

        // First set of emojis (always visible)
        emojiHappy = findViewById(R.id.emoji_happy);
        emojiSad = findViewById(R.id.emoji_sad);
        emojiAngry = findViewById(R.id.emoji_angry);
        emojiScared = findViewById(R.id.emoji_scared);
        emojiExcited = findViewById(R.id.emoji_excited);
        emojiBored = findViewById(R.id.emoji_bored);
        emojiLove = findViewById(R.id.emoji_love);

        // Second set of emojis (initially hidden)
        emojiHappyTwo = findViewById(R.id.emoji_happy_two);
        emojiSadTwo = findViewById(R.id.emoji_sad_two);
        emojiAngryTwo = findViewById(R.id.emoji_angry_two);
        emojiScaredTwo = findViewById(R.id.emoji_scared_two);
        emojiExcitedTwo = findViewById(R.id.emoji_excited_two);
        emojiBoredTwo = findViewById(R.id.emoji_bored_two);
        emojiLoveTwo = findViewById(R.id.emoji_love_two);

        feelText = findViewById(R.id.feel_text);
        emojiLayout = findViewById(R.id.emoji_Layout); // Layout for second set of emojis
        reasonSpinner = findViewById(R.id.reason_spinner);
        extraInput = findViewById(R.id.extra_input);
        submitButton = findViewById(R.id.submit_button);
    }

    private void setEmojiClickListeners() {
        View.OnClickListener moodClickListener = v -> {
            currentMood = ((TextView) v).getText().toString();
            showSnackbar("Current mood selected: " + currentMood);
        };

        View.OnClickListener desiredMoodClickListener = v -> {
            desiredMood = ((TextView) v).getText().toString();
            showSnackbar("Desired mood selected: " + desiredMood);
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

    private void showSnackbar(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }

    private void handleSubmit() {
        // If the "Keep mood" is selected, make sure desiredMood is set to currentMood
        if (moodActionSpinner.getSelectedItem().toString().equals("Keep mood")) {
            desiredMood = currentMood; // Ensure desiredMood is same as currentMood
        }

        String reason = reasonSpinner.getSelectedItem().toString();
        String extraMessage = extraInput.getText().toString();

        // Simple validation
        if (currentMood.isEmpty() || desiredMood.isEmpty()) {
            showSnackbar("Please select both your current and desired mood.");
            return;
        }

        // Process the form submission
        String summary = "Current Mood: " + currentMood + "\n"
                + "Desired Mood: " + desiredMood + "\n"
                + "Reason: " + reason + "\n"
                + "Extra: " + extraMessage;

        // Save log entry to SharedPreferences (optional)
        // SharedPreferences sharedPreferences = getSharedPreferences("MoodTrackerPrefs", MODE_PRIVATE);
        // String existingLogs = sharedPreferences.getString("moodLogs", "");
        // SharedPreferences.Editor editor = sharedPreferences.edit();
        // editor.putString("moodLogs", existingLogs + summary + "\n\n");
        // editor.apply();

        showSnackbar("Mood logged successfully!");

        // Navigate to suggestions activity
        Intent intent = new Intent(MoodActivity.this, suggestionsActivity.class);
        intent.putExtra("currentMood", currentMood);  // Pass data to next activity
        intent.putExtra("desiredMood", desiredMood);
        startActivity(intent);

        // Clear form fields after submission
        extraInput.setText("");
    }

}
