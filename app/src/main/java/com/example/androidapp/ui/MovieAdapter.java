package com.example.androidapp.ui;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidapp.data.GlideImageLoader;
import com.example.androidapp.data.ImageLoader;
import com.example.androidapp.data.Movie;
import com.example.androidapp.R;


public class MovieAdapter extends ListAdapter<Movie, MovieAdapter.MovieViewHolder> {

    public MovieAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Movie> DIFF_CALLBACK = new DiffUtil.ItemCallback<Movie>() {
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

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private TextView movieNameTextView;
        private TextView movieNameEngTextView;
        private TextView moviePremiereTextView;
        private TextView movieDescriptionTextView;
        private ImageView movieImageView;
        ImageLoader glideImageLoader = new GlideImageLoader();

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieNameTextView = itemView.findViewById(R.id.movie_name_view);
            movieNameEngTextView = itemView.findViewById(R.id.movie_name_eng_view);
            moviePremiereTextView = itemView.findViewById(R.id.movie_premiere_view);
            movieDescriptionTextView = itemView.findViewById(R.id.movie_description_view);
            movieImageView = itemView.findViewById(R.id.movie_image_view);
        }

        public void bind(Movie text) {
            movieNameTextView.setText(text.getName());
            movieNameEngTextView.setText(text.getNameEng());
            moviePremiereTextView.setText(text.getPremiere());
            movieDescriptionTextView.setText(text.getDescription());
            glideImageLoader.loadImage(text.getImage(), movieImageView);
        }
    }
}