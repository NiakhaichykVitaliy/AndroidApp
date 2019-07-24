package com.example.androidapp.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidapp.R;
import com.example.androidapp.data.GlideImageLoader;
import com.example.androidapp.data.ImageLoader;
import com.example.androidapp.data.Movie;


public class MovieAdapter extends ListAdapter<Movie, MovieAdapter.MovieViewHolder> {

    public MovieAdapter(@NonNull DiffUtil.ItemCallback<Movie> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, final int position) {
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Movie clickedDataItem = getItem(position);
                        Intent intent = new Intent(view.getContext(), MovieItemActivity.class);
                        intent.putExtra("movies", clickedDataItem);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        view.getContext().startActivity(intent);
                    }
                }
            });
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