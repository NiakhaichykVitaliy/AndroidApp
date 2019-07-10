package com.example.androidapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class MoviesFragment extends Fragment {
    MoviesRepository moviesRepository = new TestMoviesRepositoryImpl();
    RecyclerView recyclerView;
    MovieAdapter movieAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movies_fragment, container, false);

        recyclerView = view.findViewById(R.id.movies_recycler_view);

        movieAdapter = new MovieAdapter();
        recyclerView.setAdapter(movieAdapter);
        movieAdapter.setMovies(moviesRepository.getMovies());

        return view;
    }

}