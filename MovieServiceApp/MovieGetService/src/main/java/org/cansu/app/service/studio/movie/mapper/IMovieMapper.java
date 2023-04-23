package org.cansu.app.service.studio.movie.mapper;

import com.elif.studioapp.data.entity.Movie;
import org.cansu.app.service.studio.movie.dto.CountDTO;
import org.cansu.app.service.studio.movie.dto.MovieDTO;
import org.cansu.app.service.studio.movie.dto.MoviesDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "MovieMapperImpl")
public interface IMovieMapper {
    MovieDTO toMovieDTO(Movie movie);

    default MoviesDTO toMoviesDTO(List<MovieDTO> movies)
    {
        var dto = new MoviesDTO();

        dto.movies = movies;

        return dto;
    }

    default CountDTO toCountDTO(long count)
    {
        return new CountDTO(count);
    }
}
