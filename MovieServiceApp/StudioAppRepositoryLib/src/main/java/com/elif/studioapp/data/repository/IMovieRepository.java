package com.elif.studioapp.data.repository;

import com.elif.studioapp.data.entity.Movie;
import org.csystem.util.data.repository.ICrudRepository;

public interface IMovieRepository extends ICrudRepository<Movie, Long> {
    Iterable<Movie> findByMonth(int month);
    Iterable<Movie> findByYear(int year);
    Iterable<Movie> findByMonthAndYear(int month, int year);
    Iterable<Movie> findMoviesInBetween(int begin, int end);
}
