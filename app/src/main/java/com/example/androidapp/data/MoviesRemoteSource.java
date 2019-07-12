package com.example.androidapp.data;

import com.example.androidapp.listeners.GetMoviesListener;

public interface MoviesRemoteSource {
    void getMovies();

    void setGetMoviesListener(GetMoviesListener getMoviesListener);
}
