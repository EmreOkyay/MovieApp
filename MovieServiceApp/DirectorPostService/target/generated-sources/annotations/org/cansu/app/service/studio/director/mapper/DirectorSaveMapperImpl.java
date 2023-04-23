package org.cansu.app.service.studio.director.mapper;

import com.elif.studioapp.data.entity.DirectorSave;
import javax.annotation.processing.Generated;
import org.cansu.app.service.studio.director.dto.DirectorSaveDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-23T18:57:27+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class DirectorSaveMapperImpl implements IDirectorSaveMapper {

    @Override
    public DirectorSave toDirectorSave(DirectorSaveDTO directorSaveDTO) {
        if ( directorSaveDTO == null ) {
            return null;
        }

        DirectorSave directorSave = new DirectorSave();

        directorSave.directorId = directorSaveDTO.directorId;
        directorSave.firstName = directorSaveDTO.firstName;
        directorSave.middleName = directorSaveDTO.middleName;
        directorSave.familyName = directorSaveDTO.familyName;
        directorSave.birthDate = directorSaveDTO.birthDate;

        return directorSave;
    }
}
