package com.example.androidapp;

import java.util.ArrayList;
import java.util.List;

public class TestMoviesRepositoryImpl implements MoviesRepository {

    @Override
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("god bless the queen","1"));
        movies.add(new Movie("Елизавета II обожает собак породы корги", "12"));
        movies.add(new Movie("К королеве нельзя прикасаться","123"));
        movies.add(new Movie("Idi nahui","1234"));
        movies.add(new Movie("Vse esche idi nahui", "12345"));
        movies.add(new Movie("Ladno, idi v pizdy","123456"));
        movies.addAll(movies);
        movies.addAll(movies);
        return movies;
    }
}