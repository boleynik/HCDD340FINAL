package edu.psu.ist.hcdd340.finalproject;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class suggestionsActivity extends AppCompatActivity {

    private TextView appTitle;
    private TextView music1, music2;
    private TextView movie1, movie2;
    private TextView recipe1, recipe2;
    private TextView fitness1, fitness2;
    private TextView meditation1, meditation2;
    private TextView book1, book2, quote;

    private LinearLayout musicLayout, movieLayout, recipeLayout, fitnessLayout, meditationLayout, bookLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        // Initialize Views
        initializeViews();
        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);
        NavigationHelper.setupBottomNavigation(this, bottomNavigation);

        NavigationHelper.setupBottomNavigation(this, bottomNavigation);

        // Retrieve the passed data from the Intent
        Intent intent = getIntent();
        String desiredMood = intent.getStringExtra("desiredMood");

        // Set dynamic title based on the desired mood
        appTitle.setText("Suggestions for " + desiredMood);

        // Display suggestions based on the desired mood
        setSuggestions(desiredMood);
    }

    private void initializeViews() {
        appTitle = findViewById(R.id.app_title);

        // Music Section
        musicLayout = findViewById(R.id.musicLayout);
        music1 = findViewById(R.id.music1);
        music2 = findViewById(R.id.music2);

        // Movies Section
        movieLayout = findViewById(R.id.movieLayout);
        movie1 = findViewById(R.id.movie1);
        movie2 = findViewById(R.id.movie2);

        // Recipes Section
        recipeLayout = findViewById(R.id.recipeLayout);
        recipe1 = findViewById(R.id.recipe1);
        recipe2 = findViewById(R.id.recipe2);

        // Fitness Section
        fitnessLayout = findViewById(R.id.fitnessLayout);
        fitness1 = findViewById(R.id.fitness1);
        fitness2 = findViewById(R.id.fitness2);

        // Meditation Section
        meditationLayout = findViewById(R.id.meditationLayout);
        meditation1 = findViewById(R.id.med1);
        meditation2 = findViewById(R.id.med2);

        // Books Section
        bookLayout = findViewById(R.id.bookLayout);
        book1 = findViewById(R.id.book1);
        book2 = findViewById(R.id.book2);
        quote = findViewById(R.id.quote);
    }

    private void setSuggestions(String desiredMood) {
        // Show different suggestions based on the desired mood
        switch (desiredMood) {
            case "😊":
                // Happy Mood Suggestions
                music1.setText(fromHtml(getString(R.string.happy1)));
                music2.setText(fromHtml(getString(R.string.happy2)));
                movie1.setText(fromHtml(getString(R.string.happy_movie1)));
                movie2.setText(fromHtml(getString(R.string.happy_movie2)));
                recipe1.setText(fromHtml(getString(R.string.happy_recipe1)));
                recipe2.setText(fromHtml(getString(R.string.happy_recipe2)));
                fitness1.setText(fromHtml(getString(R.string.happy_workout1)));
                fitness2.setText(fromHtml(getString(R.string.happy_workout2)));
                meditation1.setText(fromHtml(getString(R.string.happy_meditation1)));
                meditation2.setText(fromHtml(getString(R.string.happy_meditation2)));
                book1.setText(fromHtml(getString(R.string.happy_book1)));
                book2.setText(fromHtml(getString(R.string.happy_book2)));
                quote.setText(fromHtml(getString(R.string.happy_quote)));
                break;
            case "😢":
                // Sad Mood Suggestions
                music1.setText(fromHtml(getString(R.string.sad_song1)));
                music2.setText(fromHtml(getString(R.string.sad_song2)));
                movie1.setText(fromHtml(getString(R.string.sad_movie1)));
                movie2.setText(fromHtml(getString(R.string.sad_movie2)));
                recipe1.setText(fromHtml(getString(R.string.sad_recipe1)));
                recipe2.setText(fromHtml(getString(R.string.sad_recipe2)));
                fitness1.setText(fromHtml(getString(R.string.sad_workout1)));
                fitness2.setText(fromHtml(getString(R.string.sad_workout2)));
                meditation1.setText(fromHtml(getString(R.string.sad_meditation1)));
                meditation2.setText(fromHtml(getString(R.string.sad_meditation2)));
                book1.setText(fromHtml(getString(R.string.sad_book1)));
                book2.setText(fromHtml(getString(R.string.sad_book2)));
                quote.setText(fromHtml(getString(R.string.sad_quote)));
                break;
            case "😡":
                // Angry Mood Suggestions
                music1.setText(fromHtml(getString(R.string.angry_song1)));
                music2.setText(fromHtml(getString(R.string.angry_song2)));
                movie1.setText(fromHtml(getString(R.string.angry_movie1)));
                movie2.setText(fromHtml(getString(R.string.angry_movie2)));
                recipe1.setText(fromHtml(getString(R.string.angry_recipe1)));
                recipe2.setText(fromHtml(getString(R.string.angry_recipe2)));
                fitness1.setText(fromHtml(getString(R.string.angry_workout1)));
                fitness2.setText(fromHtml(getString(R.string.angry_workout2)));
                meditation1.setText(fromHtml(getString(R.string.angry_meditation1)));
                meditation2.setText(fromHtml(getString(R.string.angry_meditation2)));
                book1.setText(fromHtml(getString(R.string.angry_book1)));
                book2.setText(fromHtml(getString(R.string.angry_book2)));
                quote.setText(fromHtml(getString(R.string.angry_quote)));
                break;
            case "😆":
                // Excited Mood Suggestions
                music1.setText(fromHtml(getString(R.string.excited_song1)));
                music2.setText(fromHtml(getString(R.string.excited_song2)));
                movie1.setText(fromHtml(getString(R.string.excited_movie1)));
                movie2.setText(fromHtml(getString(R.string.excited_movie2)));
                recipe1.setText(fromHtml(getString(R.string.excited_recipe1)));
                recipe2.setText(fromHtml(getString(R.string.excited_recipe2)));
                fitness1.setText(fromHtml(getString(R.string.excited_workout1)));
                fitness2.setText(fromHtml(getString(R.string.excited_workout2)));
                meditation1.setText(fromHtml(getString(R.string.excited_meditation1)));
                meditation2.setText(fromHtml(getString(R.string.excited_meditation2)));
                book1.setText(fromHtml(getString(R.string.excited_book1)));
                book2.setText(fromHtml(getString(R.string.excited_book2)));
                quote.setText(fromHtml(getString(R.string.excited_quote)));
                break;
            case "😑":
                // Bored Mood Suggestions
                music1.setText(fromHtml(getString(R.string.bored_song1)));
                music2.setText(fromHtml(getString(R.string.bored_song2)));
                movie1.setText(fromHtml(getString(R.string.bored_movie1)));
                movie2.setText(fromHtml(getString(R.string.bored_movie2)));
                recipe1.setText(fromHtml(getString(R.string.bored_recipe1)));
                recipe2.setText(fromHtml(getString(R.string.bored_recipe2)));
                fitness1.setText(fromHtml(getString(R.string.bored_workout1)));
                fitness2.setText(fromHtml(getString(R.string.bored_workout2)));
                meditation1.setText(fromHtml(getString(R.string.bored_meditation1)));
                meditation2.setText(fromHtml(getString(R.string.bored_meditation2)));
                book1.setText(fromHtml(getString(R.string.bored_book1)));
                book2.setText(fromHtml(getString(R.string.bored_book2)));
                quote.setText(fromHtml(getString(R.string.bored_quote)));
                break;
            case "😍":
                // In Love Mood Suggestions
                music1.setText(fromHtml(getString(R.string.inlove_song1)));
                music2.setText(fromHtml(getString(R.string.inlove_song2)));
                movie1.setText(fromHtml(getString(R.string.inlove_movie1)));
                movie2.setText(fromHtml(getString(R.string.inlove_movie2)));
                recipe1.setText(fromHtml(getString(R.string.inlove_recipe1)));
                recipe2.setText(fromHtml(getString(R.string.inlove_recipe2)));
                fitness1.setText(fromHtml(getString(R.string.inlove_workout1)));
                fitness2.setText(fromHtml(getString(R.string.inlove_workout2)));
                meditation1.setText(fromHtml(getString(R.string.inlove_meditation1)));
                meditation2.setText(fromHtml(getString(R.string.inlove_meditation2)));
                book1.setText(fromHtml(getString(R.string.inlove_book1)));
                book2.setText(fromHtml(getString(R.string.inlove_book2)));
                quote.setText(fromHtml(getString(R.string.inlove_quote1)));
                break;
        }

        // Enable clickable links for all TextViews
        enableLinkMovement();
    }

    private void enableLinkMovement() {
        music1.setMovementMethod(LinkMovementMethod.getInstance());
        music2.setMovementMethod(LinkMovementMethod.getInstance());
        movie1.setMovementMethod(LinkMovementMethod.getInstance());
        movie2.setMovementMethod(LinkMovementMethod.getInstance());
        recipe1.setMovementMethod(LinkMovementMethod.getInstance());
        recipe2.setMovementMethod(LinkMovementMethod.getInstance());
        fitness1.setMovementMethod(LinkMovementMethod.getInstance());
        fitness2.setMovementMethod(LinkMovementMethod.getInstance());
        meditation1.setMovementMethod(LinkMovementMethod.getInstance());
        meditation2.setMovementMethod(LinkMovementMethod.getInstance());
        book1.setMovementMethod(LinkMovementMethod.getInstance());
        book2.setMovementMethod(LinkMovementMethod.getInstance());
        quote.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private CharSequence fromHtml(String htmlString) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(htmlString, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(htmlString);
        }
    }
}
