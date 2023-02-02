package com.codigolautaro.app.movies.repositories;

import com.codigolautaro.app.movies.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long>
{
}
