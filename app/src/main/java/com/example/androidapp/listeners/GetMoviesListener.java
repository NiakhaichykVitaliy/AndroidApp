package com.example.androidapp.listeners;

import com.example.androidapp.data.Movie;

import java.util.List;

public interface GetMoviesListener {
    void onGetMoviesSuccess(List<Movie> movies);

    void onGetMoviesError(Throwable error);
}
