package edu.psu.ist.hcdd340.finalproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

public class LogActivityActivity extends AppCompatActivity {

    // Declare views
    private Toolbar topAppBar;
    private TextView logDate, emotionStatus, desiredEmotion, reasonForStress, timeLogged, interactions;
    private Button mostUsedPlaylist, genre, movie, quote, recipe;
    private NestedScrollView scrollView;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        topAppBar = findViewById(R.id.topAppBar);
        logDate = findViewById(R.id.log_date);
        emotionStatus = findViewById(R.id.emotion_status);
        desiredEmotion = findViewById(R.id.desired_emotion);
        reasonForStress = findViewById(R.id.reason_for_stress);
        timeLogged = findViewById(R.id.time_logged);
        interactions = findViewById(R.id.interactions);

        mostUsedPlaylist = findViewById(R.id.most_used_playlist);
        genre = findViewById(R.id.genre);
        movie = findViewById(R.id.movie);
        quote = findViewById(R.id.quote);
        recipe = findViewById(R.id.recipe);

        scrollView = findViewById(R.id.scrollView);

        // Set up toolbar title
        setSupportActionBar(topAppBar);
        getSupportActionBar().setTitle("muud");

        // Example button click listeners
        mostUsedPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the most used playlist button click
                logDate.setText("December 12, 2024");
                emotionStatus.setText("You were stressed: 😟");
                desiredEmotion.setText("You wanted to be happy: 😃");
                reasonForStress.setText("Reason for stress: Work 💼");
                timeLogged.setText("Time logged: 11:59 PM");
                interactions.setText("Your activity: Played soothing music 🎶");
            }
        });

        genre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the genre button click
                // Here you can update the activity with different genre-related data
                logDate.setText("December 12, 2024");
                emotionStatus.setText("You were stressed: 😟");
                desiredEmotion.setText("You wanted to be happy: 😃");
                reasonForStress.setText("Reason for stress: Work 💼");
                timeLogged.setText("Time logged: 11:59 PM");
                interactions.setText("Your activity: Listening to Pop Music 🎧");
            }
        });

        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the movie button click
                logDate.setText("December 12, 2024");
                emotionStatus.setText("You were stressed: 😟");
                desiredEmotion.setText("You wanted to be happy: 😃");
                reasonForStress.setText("Reason for stress: Work 💼");
                timeLogged.setText("Time logged: 11:59 PM");
                interactions.setText("Your activity: Watched 'Happy Gilmore' 🎬");
            }
        });

        quote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the quote button click
                logDate.setText("December 12, 2024");
                emotionStatus.setText("You were stressed: 😟");
                desiredEmotion.setText("You wanted to be happy: 😃");
                reasonForStress.setText("Reason for stress: Work 💼");
                timeLogged.setText("Time logged: 11:59 PM");
                interactions.setText("Your activity: Read an inspiring quote 📚");
            }
        });

        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the recipe button click
                logDate.setText("December 12, 2024");
                emotionStatus.setText("You were stressed: 😟");
                desiredEmotion.setText("You wanted to be happy: 😃");
                reasonForStress.setText("Reason for stress: Work 💼");
                timeLogged.setText("Time logged: 11:59 PM");
                interactions.setText("Your activity: Made grilled cheese and tomato soup 🧑‍🍳");
            }
        });
    }
}




