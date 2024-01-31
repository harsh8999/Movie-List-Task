package com.example.tmdbmovie.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "moviesdb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private String id;

    private String original_language;
    private String original_title;
    private String overview;
    private String title;
    private boolean adult;
}
