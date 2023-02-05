package com.codigolautaro.app.movies.services;

import com.codigolautaro.app.movies.exceptions.RequestException;
import com.codigolautaro.app.movies.models.Movie;
import com.codigolautaro.app.movies.repositories.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService
{
    @Autowired
    IMovieRepository movieRepository;

    public List<Movie> getALLMovies()
    {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id)
    {
        return movieRepository.findById(id).orElse(null);
    }

    public String saveMovie(List<Movie> movies)
    {
        for (Movie m : movies)
        {
        movieRepository.save(m);
        }
        return "Saved";

    }

    public String updateMovies(Long id, Movie request)
    {
        Movie movieToUpdate = movieRepository.findById(id).get();
        movieToUpdate.setTitle(request.getTitle());
        movieToUpdate.setGenre(request.getGenre());
        movieToUpdate.setDuration(request.getDuration());
        movieToUpdate.setDescription(request.getDescription());
        movieRepository.save(movieToUpdate);
        return "Movie Updated";
    }

    public String deleteMovie(Long id)
    {
        movieRepository.deleteById(id);
        return "Movie deleted";
    }

    public String deleteAllMovies()
    {
        movieRepository.deleteAll();
        return "All movies were removed";
    }

}
