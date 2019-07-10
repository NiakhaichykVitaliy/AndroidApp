package com.example.androidapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class MoviesFragment extends Fragment implements MoviesRepository {
    TestMoviesRepositoryImpl testMoviesRepository = new TestMoviesRepositoryImpl();
    RecyclerView recyclerView;
    MovieAdapter movieAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movies_fragment, container, false);

        recyclerView = view.findViewById(R.id.movies_recycler_view);

        movieAdapter = new MovieAdapter();
        recyclerView.setAdapter(movieAdapter);
        movieAdapter.setMovies(getMovies());

        return view;
    }

    @Override
    public List<Movie> getMovies() {
        return testMoviesRepository.getMovies();
    }
}