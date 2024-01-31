package com.example.tmdbmovie.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.tmdbmovie.entity.Movie;

public interface MovieRepository extends MongoRepository<Movie, String>{

}
