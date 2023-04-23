package org.cansu.app.service.studio.director.mapper;

import com.elif.studioapp.data.entity.DirectorSave;
import org.cansu.app.service.studio.director.dto.DirectorSaveDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "DirectorSaveMapperImpl", componentModel = "spring")
public interface IDirectorSaveMapper {
    DirectorSave toDirectorSave(DirectorSaveDTO directorSaveDTO);
}
