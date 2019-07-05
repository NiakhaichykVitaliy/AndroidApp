package com.example.androidapp;

import java.util.ArrayList;
import java.util.List;

public class TestMoviesRepositoryImpl implements MoviesRepository {

    @Override
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("god bless the queen","1",
                "https://st.overclockers.ru/images/lab/2018/09/15/1/001_art_big.jpg"));
        movies.add(new Movie("Елизавета II обожает собак породы корги", "12",
                "https://i.pinimg.com/736x/66/dc/53/66dc5311ff5f0e099c54d55524248311.jpg"));
        movies.add(new Movie("К королеве нельзя прикасаться","123",
                "https://images11.cosmopolitan.ru/upload/img_cache/b64/b64722e8818c4b76e212eb30ef108940_fitted_358x700.jpg"));
        movies.add(new Movie("Idi nahui","1234",
                "https://www.peoples.ru/character/movie/iron_man/iron_1.jpg"));
        movies.add(new Movie("Vse esche idi nahui", "12345",
                "https://images11.cosmopolitan.ru/upload/img_cache/b53/b53dccad1361f9b66c08af97c8cef2d8_fitted_358x700.jpg"));
        movies.add(new Movie("Ladno, idi v pizdy","123456",
                "https://i.citrus.ua/uploads/content/product-photos/fedenicheva/March/th.jpg"));
        movies.addAll(movies);
        movies.addAll(movies);
        return movies;
    }
}