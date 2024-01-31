package com.example.tmdbmovie.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.tmdbmovie.entity.Movie;
import com.example.tmdbmovie.repository.MovieRepository;

@Service
public class MovieServiceImplementation implements MovieServiceInterface {

    private final String tmdbApiToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2NjI1Mzg3ZWVmZGY2NmQ2YTJkNTI5YjUzNDQ2MjI1OCIsInN1YiI6IjY1YjlkOWY5OTBmY2EzMDE3YjA4MWQ0NiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.k54N4rStwWJpg7TNxUiXVJP_j-xR8YFDDx20noirefk";
    private final String tmdbApiKey = "6625387eefdf66d6a2d529b534462258";
    private final String tmdbUrl = "https://api.themoviedb.org/3/account/null/favorite/movies?language=en-US&page=1&sort_by=created_at.asc";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MovieRepository movieRepository;


    @Override
    public List<Movie> saveMovies() {
        // structure URL
        RequestEntity<Void> requestEntity;
        try {
            requestEntity = new RequestEntity<>(getHttpHeaders(), HttpMethod.GET, new URI(tmdbUrl));
        } catch (URISyntaxException e) {
            throw new RuntimeException("Error creating request URI", e);
        }

        ResponseEntity<Map> responseEntity = restTemplate.exchange(requestEntity, Map.class);
        // System.out.println(responseEntity.getBody());
        Map<String, Object> result = responseEntity.getBody();
        List<Map<String, Object>> movies = (List) result.get("results");
        
        // System.out.println(movies.get(0));

        for(Map<String, Object> movie: movies) {
            Movie movieToSave = new Movie();
            movieToSave.setId(movie.get("id").toString());
            movieToSave.setOriginal_language((String) movie.get("original_language"));
            movieToSave.setOriginal_title((String) movie.get("original_title"));
            movieToSave.setAdult((boolean) movie.get("adult"));
            movieToSave.setOverview((String) movie.get("overview"));
            movieToSave.setTitle((String) movie.get("title"));

            // save in Database
            movieRepository.save(movieToSave);
        }

        

        return movieRepository.findAll();
    }

    HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + tmdbApiToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    
    
}
