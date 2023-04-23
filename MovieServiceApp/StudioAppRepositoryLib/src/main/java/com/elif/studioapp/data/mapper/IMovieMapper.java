package com.elif.studioapp.data.mapper;

import com.elif.studioapp.data.entity.Movie;
import com.elif.studioapp.data.entity.MovieSave;
import com.karandev.util.mapstruct.IOptionalMapper;
import org.mapstruct.Mapper;

@Mapper(implementationName = "MovieMapperImpl")
public interface IMovieMapper extends IOptionalMapper {
    Movie toMovie(MovieSave movieSave);
}
