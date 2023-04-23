package org.cansu.app.service.studio.movie.mapper;

import com.elif.studioapp.data.entity.MovieSave;
import org.cansu.app.service.studio.movie.dto.MovieSaveDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "MovieSaveMapperImpl", componentModel = "spring")
public interface IMovieSaveMapper {
    MovieSave toMovieSave(MovieSaveDTO movieSaveDTO);
}
