package com.example.androidapp.data;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

public class MovieDiffUtilCallback {

    public static final DiffUtil.ItemCallback<Movie> DIFF_CALLBACK = new DiffUtil.ItemCallback<Movie>() {
        @Override
        public boolean areItemsTheSame(@NonNull Movie oldMovie, @NonNull Movie newMovie) {
            return oldMovie.getName().equals(newMovie.getName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Movie oldMovie, @NonNull Movie newMovie) {
            return oldMovie.getName().equals(newMovie.getName()) &&
                    oldMovie.getDescription().equals(newMovie.getDescription()) &&
                    oldMovie.getNameEng().equals(newMovie.getNameEng()) &&
                    oldMovie.getPremiere().equals(newMovie.getPremiere()) &&
                    oldMovie.getImage().equals(newMovie.getImage());
        }
    };
}