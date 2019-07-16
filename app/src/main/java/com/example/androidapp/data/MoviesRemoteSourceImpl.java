package com.example.androidapp.data;

import com.example.androidapp.listeners.GetMoviesListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.androidapp.data.MoviesApi.BASE_URL;

public class MoviesRemoteSourceImpl implements MoviesRemoteSource {
    private GetMoviesListener getMoviesListener;
    private MoviesApi moviesApi;

    public MoviesRemoteSourceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        moviesApi = retrofit.create(MoviesApi.class);
    }

    @Override
    public void getMovies() {
        moviesApi.getMovies().enqueue(new Callback<MoviesList>() {

            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                getMoviesListener.onGetMoviesSuccess(response.body().getMovieList());
            }

            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {
                getMoviesListener.onGetMoviesError(t);
            }
        });
    }

    @Override
    public void setGetMoviesListener(GetMoviesListener getMoviesListener) {
        this.getMoviesListener = getMoviesListener;
    }
}
