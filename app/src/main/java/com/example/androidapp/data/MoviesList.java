package com.example.androidapp.data;

import java.util.ArrayList;
import java.util.List;

public class MoviesList {
    private List<Movie> movieList = new ArrayList<>();

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}