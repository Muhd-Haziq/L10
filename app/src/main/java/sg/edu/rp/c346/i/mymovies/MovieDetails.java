package sg.edu.rp.c346.i.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class MovieDetails extends AppCompatActivity {

    TextView tvTitle, tvYear, tvRated, tvDescription, tvGenre, tvWatchedOn, tvInTheatre;
    ImageView ivRating;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        Intent movieDetails = getIntent();

        tvTitle = findViewById(R.id.textViewTitle);
        tvYear = findViewById(R.id.textViewYear);
        tvRated = findViewById(R.id.textViewYear);
        tvYear = findViewById(R.id.textViewYear);
        tvYear = findViewById(R.id.textViewYear);

        ivRating = findViewById(R.id.imageViewRating);


        String title = movieDetails.getStringExtra("title");
        int year = movieDetails.getIntExtra("year", 0);
        String rating = movieDetails.getStringExtra("rated");
        String genre = movieDetails.getStringExtra("genre");
        String watched_on = movieDetails.getStringExtra("watched_on");
        String in_theatre = movieDetails.getStringExtra("in_theatre");
        String description = movieDetails.getStringExtra("description");


        if(rating == "g"){
            ivRating.setImageResource(R.drawable.rating_g);
        }else if(rating == "pg"){
            ivRating.setImageResource(R.drawable.rating_pg);
        }else if(rating == "pg13"){
            ivRating.setImageResource(R.drawable.rating_pg13);
        }else if(rating == "nc16"){
            ivRating.setImageResource(R.drawable.rating_nc16);
        }else if(rating == "m18"){
            ivRating.setImageResource(R.drawable.rating_m18);
        }else{
            ivRating.setImageResource(R.drawable.rating_r21);
        }



        tvTitle.setText(title);
        tvYear.setText(year + " - ");
        tvGenre.setText(genre);
        tvDescription.setText(description);
        tvInTheatre.setText("In Theatre: " + in_theatre);
        tvWatchedOn.setText("Watch On: " + watched_on);


    }
}
