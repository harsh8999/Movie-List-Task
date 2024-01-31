package com.example.tmdbmovie.services;

import java.util.List;

import com.example.tmdbmovie.entity.Movie;

public interface MovieServiceInterface {

    /**
     * This method calls the external API and saves the received data in database
     * @return List of movies saved
     */
    List<Movie> saveMovies();

}
