package com.example.androidapp.data;

import com.example.androidapp.listeners.GetMoviesListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.androidapp.data.MoviesApi.BASE_URL;
import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;

public class MoviesRemoteSourceImpl implements MoviesRemoteSource {
    private GetMoviesListener getMoviesListener;
    private MoviesApi moviesApi;
    private static final int TIMEOUT_SECONDS = 30;


    public MoviesRemoteSourceImpl() {
        OkHttpClient.Builder okhttpBuilder = new OkHttpClient.Builder()
                .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .callTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okhttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        moviesApi = retrofit.create(MoviesApi.class);
    }

    @Override
    public void getMovies() {
        moviesApi.getMovies().enqueue(new Callback<MoviesList>() {

            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                if (response.body() != null && getMoviesListener != null) {
                    getMoviesListener.onGetMoviesSuccess(response.body().getMovieList());
                }
            }

            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {
                if (getMoviesListener != null) {
                    getMoviesListener.onGetMoviesError(t);
                }
            }
        });
    }

    @Override
    public void setGetMoviesListener(GetMoviesListener getMoviesListener) {
        this.getMoviesListener = getMoviesListener;
    }
}