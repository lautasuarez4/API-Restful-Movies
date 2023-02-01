package com.codigolautaro.app.movies.controllers;

import com.codigolautaro.app.movies.repositories.IMovieRepository;
import com.codigolautaro.app.movies.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    public ResponseEntity getAllMovies(){

    }

}
