package com.codigolautaro.app.movies.controllers;

import com.codigolautaro.app.movies.exceptions.RequestException;
import com.codigolautaro.app.movies.models.Movie;
import com.codigolautaro.app.movies.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController
{
    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity getAllMovies()
    {
        try
        {
            return new ResponseEntity<>(movieService.getALLMovies(), HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>("An error occured when processing your request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getMovieById(@PathVariable Long id)
    {
        if (id <= 0)
            throw new RuntimeException("Id must be > 0");

        Movie movie = movieService.getMovieById(id);

        if(movie == null)
            throw new RequestException("Movie doesn't exist");

        return new ResponseEntity<>(movie, HttpStatus.OK);

    }

    @PostMapping("/save")
    public ResponseEntity saveMovie(@RequestBody (required = false) List<Movie> m)
    {
        if (m == null || camposNulos(m))
            return new ResponseEntity<>("Please check again, wrong request", HttpStatus.BAD_REQUEST);
        try
        {
            return new ResponseEntity(movieService.saveMovie(m), HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>("An error occured when processing your request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@PathVariable Long id, @RequestBody(required = false) Movie request )
    {
        if (id<=0)
            return new ResponseEntity<>("Id must be > 0", HttpStatus.BAD_REQUEST);

        if (request == null)
            return new ResponseEntity<>("Please check again, wrong request", HttpStatus.BAD_REQUEST);

        try
        {
            return new ResponseEntity<>(movieService.updateMovies(id, request), HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>("An error occured when processing your request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Long id)
    {
        if (id <= 0)
            throw new RuntimeException("Id must be > 0");

        Movie movie = movieService.getMovieById(id);

        if(movie == null)
            throw new RequestException("Movie doesn't exist");

        return new ResponseEntity<>(movieService.deleteMovie(id), HttpStatus.OK);
    }

    @DeleteMapping("delete/all")
    public ResponseEntity deleteAllMovies()
    {
        try {
            return new ResponseEntity<>(movieService.deleteAllMovies(), HttpStatus.OK);
        } catch (RuntimeException e)
        {
            return new ResponseEntity<>("An error occured when processing your request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public boolean camposNulos(List<Movie> movies)
    {
        for (Movie m : movies)
        {
            if(m.getTitle() == null || m.getGenre() == null || m.getDescription() == null || m.getDuration()==0)
                return true;
        }
        return false;
    }
}
