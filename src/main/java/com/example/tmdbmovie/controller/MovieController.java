package com.example.tmdbmovie.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.tmdbmovie.entity.Movie;
import com.example.tmdbmovie.services.MovieServiceInterface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class MovieController {
    
    @Autowired
    private MovieServiceInterface movieService;

    @GetMapping("/movie")
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<>(movieService.saveMovies(), HttpStatus.OK);
    }
    
}
