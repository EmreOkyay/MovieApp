package org.cansu.app.service.studio.director.mapper;

import com.elif.studioapp.data.entity.Director;
import com.elif.studioapp.data.entity.Movie;
import org.cansu.app.service.studio.director.dto.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "DirectorMapperImpl")
public interface IDirectorMapper {
    DirectorDTO toDirectorDTO(Director director);

    default DirectorsDTO toDirectorsDTO(List<DirectorDTO> directors)
    {
        var dto = new DirectorsDTO();

        dto.directors = directors;

        return dto;
    }

    default CountDTO toCountDTO(long count)
    {
        return new CountDTO(count);
    }
}
