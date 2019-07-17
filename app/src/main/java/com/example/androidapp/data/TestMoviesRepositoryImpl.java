package com.example.androidapp.data;

import java.util.ArrayList;
import java.util.List;

public class TestMoviesRepositoryImpl implements MoviesRepository {

    @Override
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Человек-паук: Через Вселенные"
                , "Teen Miles Morales becomes Spider-Man of his reality, crossing his path with five counterparts from other dimensions to stop a threat for all realities."
                , "https://st.overclockers.ru/images/lab/2018/09/15/1/001_art_big.jpg"
                , "Spider-Man: Into the Spider-Verse"
                , "2018"));
        movies.add(new Movie("Капитан Марвел"
                , "Carol Danvers becomes one of the universe's most powerful heroes when Earth is caught in the middle of a galactic war between two alien races."
                , "https://i.pinimg.com/736x/66/dc/53/66dc5311ff5f0e099c54d55524248311.jpg"
                , "Captain Marvel"
                , "2019"));
        movies.add(new Movie("Первый мститель"
                , "Steve Rogers, a rejected military soldier transforms into Captain America after taking a dose of a Super-Soldier serum. But being Captain America comes at a price as he attempts to take down a war monger and a terrorist organization."
                , "https://images11.cosmopolitan.ru/upload/img_cache/b64/b64722e8818c4b76e212eb30ef108940_fitted_358x700.jpg"
                , "Captain America: The First Avenger"
                , "2011"));
        movies.add(new Movie("Железный человек"
                , "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil."
                , "https://www.peoples.ru/character/movie/iron_man/iron_1.jpg"
                , "Iron Man"
                , "2008"));
        movies.add(new Movie("Тор"
                , "The powerful but arrogant god Thor is cast out of Asgard to live amongst humans in Midgard (Earth), where he soon becomes one of their finest defenders."
                , "https://images11.cosmopolitan.ru/upload/img_cache/b53/b53dccad1361f9b66c08af97c8cef2d8_fitted_358x700.jpg"
                , "Thor"
                , "2011"));
        movies.add(new Movie("Стражи галактики"
                , "A group of intergalactic criminals must pull together to stop a fanatical warrior with plans to purge the universe."
                , "https://i.citrus.ua/uploads/content/product-photos/fedenicheva/March/th.jpg"
                , "Guardians of the Galaxy"
                , "2014"));
        return movies;
    }
}