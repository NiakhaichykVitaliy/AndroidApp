package com.example.androidapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidapp.R;
import com.example.androidapp.data.GlideImageLoader;
import com.example.androidapp.data.ImageLoader;
import com.example.androidapp.data.Movie;

public class MovieItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_item_activity);

/*        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }*/

        ImageLoader glideImageLoader = new GlideImageLoader();

        Intent intent = getIntent();

        Movie movie = intent.getParcelableExtra("movies");
        String image = movie.getImage();
        String name = movie.getName();
        String nameEng = movie.getNameEng();
        String premiere = movie.getPremiere();
        String description = movie.getDescription();

        ImageView movieImageView = findViewById(R.id.movie_item_image_view);
        glideImageLoader.loadImage(image, movieImageView);

        TextView movieNameTextView = findViewById(R.id.movie_item_name_view);
        movieNameTextView.setText(name);

        TextView movieNameEngTextView = findViewById(R.id.movie_item_name_eng_view);
        movieNameEngTextView.setText(nameEng);

        TextView moviePremiereTextView = findViewById(R.id.movie_premiere);
        moviePremiereTextView.setText(premiere);

        TextView movieDescriptionTextView = findViewById(R.id.movie_item_description_view);
        movieDescriptionTextView.setText(description);
    }
}