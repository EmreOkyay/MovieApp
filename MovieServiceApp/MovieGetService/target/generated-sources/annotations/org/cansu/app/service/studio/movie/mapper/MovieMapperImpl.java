package org.cansu.app.service.studio.movie.mapper;

import com.elif.studioapp.data.entity.Movie;
import javax.annotation.processing.Generated;
import org.cansu.app.service.studio.movie.dto.MovieDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-05T02:02:47+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class MovieMapperImpl implements IMovieMapper {

    @Override
    public MovieDTO toMovieDTO(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieDTO movieDTO = new MovieDTO();

        movieDTO.movieId = movie.getMovieId();
        movieDTO.name = movie.getName();
        movieDTO.sceneDate = movie.getSceneDate();
        movieDTO.rating = movie.getRating();
        movieDTO.cost = movie.getCost();
        movieDTO.imdb = movie.getImdb();

        return movieDTO;
    }
}
