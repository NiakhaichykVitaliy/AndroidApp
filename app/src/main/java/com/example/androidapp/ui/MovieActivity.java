package com.example.androidapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidapp.R;
import com.example.androidapp.data.BaseActivity;
import com.example.androidapp.data.GlideImageLoader;
import com.example.androidapp.data.ImageLoader;
import com.example.androidapp.data.Movie;

public class MovieActivity extends BaseActivity {
    private ImageView movieImageView;
    private TextView movieNameTextView;
    private TextView movieNameEngTextView;
    private TextView moviePremiereTextView;
    private TextView movieDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_activity);

        backArrowButton();
        getMovie();

    }

    public void backArrowButton() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void getMovie() {
        ImageLoader glideImageLoader = new GlideImageLoader();

        Intent intent = getIntent();

        Movie movie = intent.getParcelableExtra("movies");
        String image = movie.getImage();
        String name = movie.getName();
        String nameEng = movie.getNameEng();
        String premiere = movie.getPremiere();
        String description = movie.getDescription();

        movieImageView = findViewById(R.id.movie_item_image_view);
        glideImageLoader.loadImage(image, movieImageView);

        movieNameTextView = findViewById(R.id.movie_item_name_view);
        movieNameTextView.setText(name);

        movieNameEngTextView = findViewById(R.id.movie_item_name_eng_view);
        movieNameEngTextView.setText(nameEng);

        moviePremiereTextView = findViewById(R.id.movie_item_premiere_view);
        moviePremiereTextView.setText(premiere);

        movieDescriptionTextView = findViewById(R.id.movie_item_description_view);
        movieDescriptionTextView.setText(description);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(name);
    }
}