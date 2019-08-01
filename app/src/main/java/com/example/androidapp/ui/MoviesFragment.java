package com.example.androidapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.androidapp.R;
import com.example.androidapp.data.Movie;
import com.example.androidapp.data.MovieDiffUtilCallback;
import com.example.androidapp.data.MoviesRemoteSource;
import com.example.androidapp.data.MoviesRemoteSourceImpl;
import com.example.androidapp.data.MoviesRepository;
import com.example.androidapp.data.TestMoviesRepositoryImpl;
import com.example.androidapp.listeners.GetMoviesListener;

import java.util.List;


public class MoviesFragment extends Fragment implements GetMoviesListener {

    private MoviesRepository moviesRepository = new TestMoviesRepositoryImpl();
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private MoviesRemoteSource moviesRemoteSource = new MoviesRemoteSourceImpl();
    private ImageView movieImageView;

    @Override
    public void onStart() {
        super.onStart();
        moviesRemoteSource.setGetMoviesListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        moviesRemoteSource.setGetMoviesListener(null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movies_fragment, container, false);

        recyclerView = view.findViewById(R.id.movies_recycler_view);

        moviesRemoteSource.setGetMoviesListener(this);

        movieAdapter = new MovieAdapter(new MovieDiffUtilCallback());
        recyclerView.setAdapter(movieAdapter);
        movieAdapter.submitList(moviesRepository.getMovies());
        moviesRemoteSource.getMovies();
        return view;
    }

    @Override
    public void onGetMoviesSuccess(final List<Movie> movies) {
        final String MOVIE_ITEM_IMAGE_ANIMATION = "movie_item_image_animation";
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    movieAdapter.submitList(movies);
                    movieAdapter.setOnItemClickListener(new MovieAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            Movie clickedDataItem = movies.get(position);
                            movieImageView = recyclerView.findViewById(R.id.movie_image_view);
                            ActivityOptionsCompat option;
                            option = ActivityOptionsCompat.makeSceneTransitionAnimation
                                    (getActivity(), movieImageView, MOVIE_ITEM_IMAGE_ANIMATION);
                            Intent intent = new Intent(getActivity(), MovieActivity.class);
                            intent.putExtra("movies", clickedDataItem);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent, option.toBundle());
                        }
                    });
                }
            });
        }
    }

    @Override
    public void onGetMoviesError(final Throwable error) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}