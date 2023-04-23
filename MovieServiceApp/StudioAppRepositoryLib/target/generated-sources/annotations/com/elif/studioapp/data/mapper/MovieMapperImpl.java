package com.elif.studioapp.data.mapper;

import com.elif.studioapp.data.entity.Movie;
import com.elif.studioapp.data.entity.MovieSave;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-23T19:22:41+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class MovieMapperImpl implements IMovieMapper {

    @Override
    public Movie toMovie(MovieSave movieSave) {
        if ( movieSave == null ) {
            return null;
        }

        long movieId = 0L;
        String name = null;
        LocalDate sceneDate = null;
        int rating = 0;
        double cost = 0.0d;
        float imdb = 0.0f;

        movieId = movieSave.movieId;
        name = movieSave.name;
        sceneDate = movieSave.sceneDate;
        rating = movieSave.rating;
        cost = movieSave.cost;
        imdb = movieSave.imdb;

        Movie movie = new Movie( movieId, name, sceneDate, rating, cost, imdb );

        return movie;
    }
}
