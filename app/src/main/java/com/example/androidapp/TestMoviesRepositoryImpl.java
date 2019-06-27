package com.example.androidapp;

import java.util.ArrayList;
import java.util.List;

public class TestMoviesRepositoryImpl implements MoviesRepository {

    @Override
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("god bless the queen"));
        movies.add(new Movie("Елизавета II обожает собак породы корги"));
        movies.add(new Movie("К королеве нельзя прикасаться"));
        return movies;
    }
}