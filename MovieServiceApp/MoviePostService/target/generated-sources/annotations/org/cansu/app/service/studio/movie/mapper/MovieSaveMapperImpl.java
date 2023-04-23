package org.cansu.app.service.studio.movie.mapper;

import com.elif.studioapp.data.entity.MovieSave;
import javax.annotation.processing.Generated;
import org.cansu.app.service.studio.movie.dto.MovieSaveDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-23T19:05:18+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class MovieSaveMapperImpl implements IMovieSaveMapper {

    @Override
    public MovieSave toMovieSave(MovieSaveDTO movieSaveDTO) {
        if ( movieSaveDTO == null ) {
            return null;
        }

        MovieSave movieSave = new MovieSave();

        movieSave.movieId = movieSaveDTO.movieId;
        movieSave.name = movieSaveDTO.name;
        movieSave.sceneDate = movieSaveDTO.sceneDate;
        movieSave.rating = movieSaveDTO.rating;
        movieSave.cost = movieSaveDTO.cost;
        movieSave.imdb = movieSaveDTO.imdb;

        return movieSave;
    }
}
