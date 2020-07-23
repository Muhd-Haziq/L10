package sg.edu.rp.c346.i.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovies;
    ArrayList<Movie> alMovies;
    CustomAdapter mAdapter;
    Movie m1, m2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovies = findViewById(R.id.listViewMovies);

        Calendar cal = Calendar.getInstance();



        alMovies = new ArrayList<>();
        cal.set(2014, 11, 15);
        m1 = new Movie("The Avengers", 2012, "pg13", "Action | Sci-Fi", Calendar.getInstance(), "Golden Village - Bishan", "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.");
        alMovies.add(m1);

        cal.set(2015, 5, 15);
        m2 = new Movie("Planes", 2013, "pg", "Animation | Comedy", Calendar.getInstance(),"Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.");

        alMovies.add(m2);

        mAdapter = new CustomAdapter(this, R.layout.row, alMovies);
        lvMovies.setAdapter(mAdapter);

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent details = new Intent(MainActivity.this, MovieDetails.class);
                details.putExtra("title", alMovies.get(position).getTitle());
                details.putExtra("year", alMovies.get(position).getYear());
                details.putExtra("rated", alMovies.get(position).getRated());
                details.putExtra("genre", alMovies.get(position).getGenre());
                details.putExtra("watched_on", alMovies.get(position).getWatched_on().toString());
                details.putExtra("in_theatre", alMovies.get(position).getIn_theatre());
                details.putExtra("description", alMovies.get(position).getDescription());

                startActivity(details);

            }
        });
    }


}
