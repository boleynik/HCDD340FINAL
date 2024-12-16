package edu.psu.ist.hcdd340.finalproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class suggestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        // Retrieve the selected mood from the intent
        String selectedMood = getIntent().getStringExtra("selectedMood");

        // Update the content dynamically based on the mood
        updateContentBasedOnMood(selectedMood);
    }

    private void updateContentBasedOnMood(String mood) {
        // Titles
        TextView titleTextView = findViewById(R.id.app_title);

        // Music
        TextView music1 = findViewById(R.id.music1);
        TextView music2 = findViewById(R.id.music2);

        // Movies
        TextView movie1 = findViewById(R.id.movie1);
        TextView movie2 = findViewById(R.id.movie2);

        // Recipes
        TextView recipe1 = findViewById(R.id.recipe1);
        TextView recipe2 = findViewById(R.id.recipe2);

        // Workouts
        TextView fitness1 = findViewById(R.id.fitness1);
        TextView fitness2 = findViewById(R.id.fitness2);

        // Meditations
        TextView med1 = findViewById(R.id.med1);
        TextView med2 = findViewById(R.id.med2);

        // Books and Quotes
        TextView book1 = findViewById(R.id.book1);
        TextView book2 = findViewById(R.id.book2);
        TextView quote = findViewById(R.id.quote);

        // Update resources based on the mood
        switch (mood) {
            case "happy":
                titleTextView.setText("Suggestions for Feeling Happy!");
                music1.setText(R.string.happy1);
                music2.setText(R.string.happy2);
                movie1.setText(R.string.happy_movie1);
                movie2.setText(R.string.happy_movie2);
                recipe1.setText(R.string.happy_recipe1);
                recipe2.setText(R.string.happy_recipe2);
                fitness1.setText(R.string.happy_workout1);
                fitness2.setText(R.string.happy_workout2);
                med1.setText(R.string.happy_meditation1);
                med2.setText(R.string.happy_meditation2);
                book1.setText(R.string.happy_book1);
                book2.setText(R.string.happy_book2);
                quote.setText(R.string.happy_quote);
                break;

            case "sad":
                titleTextView.setText("Suggestions for Feeling Sad");
                music1.setText(R.string.sad_song1);
                music2.setText(R.string.sad_song2);
                movie1.setText(R.string.sad_movie1);
                movie2.setText(R.string.sad_movie2);
                recipe1.setText(R.string.sad_recipe1);
                recipe2.setText(R.string.sad_recipe2);
                fitness1.setText(R.string.sad_workout1);
                fitness2.setText(R.string.sad_workout2);
                med1.setText(R.string.sad_meditation1);
                med2.setText(R.string.sad_meditation2);
                book1.setText(R.string.sad_book1);
                book2.setText(R.string.sad_book2);
                quote.setText(R.string.sad_quote);
                break;

            case "angry":
                titleTextView.setText("Suggestions for Feeling Angry");
                music1.setText(R.string.angry_song1);
                music2.setText(R.string.angry_song2);
                movie1.setText(R.string.angry_movie1);
                movie2.setText(R.string.angry_movie2);
                recipe1.setText(R.string.angry_recipe1);
                recipe2.setText(R.string.angry_recipe2);
                fitness1.setText(R.string.angry_workout1);
                fitness2.setText(R.string.angry_workout2);
                med1.setText(R.string.angry_meditation1);
                med2.setText(R.string.angry_meditation2);
                book1.setText(R.string.angry_book1);
                book2.setText(R.string.angry_book2);
                quote.setText(R.string.angry_quote);
                break;

            case "stressed":
                titleTextView.setText("Suggestions for Feeling Stressed");
                music1.setText(R.string.stressed_song1);
                music2.setText(R.string.stressed_song2);
                movie1.setText(R.string.stressed_movie1);
                movie2.setText(R.string.stressed_movie2);
                recipe1.setText(R.string.stressed_recipe1);
                recipe2.setText(R.string.stressed_recipe2);
                fitness1.setText(R.string.stressed_workout1);
                fitness2.setText(R.string.stressed_workout2);
                med1.setText(R.string.stressed_meditation1);
                med2.setText(R.string.stressed_meditation2);
                book1.setText(R.string.stressed_book1);
                book2.setText(R.string.stressed_book2);
                quote.setText(R.string.stressed_quote);
                break;

            case "excited":
                titleTextView.setText("Suggestions for Feeling Excited");
                music1.setText(R.string.excited_song1);
                music2.setText(R.string.excited_song2);
                movie1.setText(R.string.excited_movie1);
                movie2.setText(R.string.excited_movie2);
                recipe1.setText(R.string.excited_recipe1);
                recipe2.setText(R.string.excited_recipe2);
                fitness1.setText(R.string.excited_workout1);
                fitness2.setText(R.string.excited_workout2);
                med1.setText(R.string.excited_meditation1);
                med2.setText(R.string.excited_meditation2);
                book1.setText(R.string.excited_book1);
                book2.setText(R.string.excited_book2);
                quote.setText(R.string.excited_quote);
                break;

            case "bored":
                titleTextView.setText("Suggestions for Feeling Bored");
                music1.setText(R.string.bored_song1);
                music2.setText(R.string.bored_song2);
                movie1.setText(R.string.bored_movie1);
                movie2.setText(R.string.bored_movie2);
                recipe1.setText(R.string.bored_recipe1);
                recipe2.setText(R.string.bored_recipe2);
                fitness1.setText(R.string.bored_workout1);
                fitness2.setText(R.string.bored_workout2);
                med1.setText(R.string.bored_meditation1);
                med2.setText(R.string.bored_meditation2);
                book1.setText(R.string.bored_book1);
                book2.setText(R.string.bored_book2);
                quote.setText(R.string.bored_quote);
                break;

            case "love":
                titleTextView.setText("Suggestions for Feeling In Love");
                music1.setText(R.string.inlove_song1);
                music2.setText(R.string.inlove_song2);
                movie1.setText(R.string.inlove_movie1);
                movie2.setText(R.string.inlove_movie2);
                recipe1.setText(R.string.inlove_recipe1);
                recipe2.setText(R.string.inlove_recipe2);
                fitness1.setText(R.string.inlove_workout1);
                fitness2.setText(R.string.inlove_workout2);
                med1.setText(R.string.inlove_meditation1);
                med2.setText(R.string.inlove_meditation2);
                book1.setText(R.string.inlove_book1);
                book2.setText(R.string.inlove_book2);
                quote.setText(R.string.inlove_quote1);
                break;

            default:
                titleTextView.setText("Suggestions for You");
                break;
        }
    }
}
