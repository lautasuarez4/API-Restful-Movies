package com.codigolautaro.app.movies.services;

import com.codigolautaro.app.movies.controllers.MovieController;
import com.codigolautaro.app.movies.models.Movie;
import com.codigolautaro.app.movies.repositories.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    IMovieRepository movieRepository;

    public List<Movie> getALLMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return (Movie) movieRepository.findById(id).get();
    }
    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void saveMovies(List<Movie> movies){
        for (Movie m : movies){
            movieRepository.save(m);
        }
    }

    public void updateMovies()

}
