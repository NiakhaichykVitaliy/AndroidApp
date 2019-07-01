package com.example.androidapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MoviesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movies_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.movies_recycler_view);

        MovieAdapter movieAdapter = new MovieAdapter();
        recyclerView.setAdapter(movieAdapter);
        movieAdapter.setMovies(new TestMoviesRepositoryImpl().getMovies());

        return view;
    }
}