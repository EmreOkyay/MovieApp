package org.cansu.app.service.studio.director.mapper;

import com.elif.studioapp.data.entity.Director;
import javax.annotation.processing.Generated;
import org.cansu.app.service.studio.director.dto.DirectorDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-05T02:32:02+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class DirectorMapperImpl implements IDirectorMapper {

    @Override
    public DirectorDTO toDirectorDTO(Director director) {
        if ( director == null ) {
            return null;
        }

        DirectorDTO directorDTO = new DirectorDTO();

        directorDTO.firstName = director.getFirstName();
        directorDTO.middleName = director.getMiddleName();
        directorDTO.familyName = director.getFamilyName();
        directorDTO.birthDate = director.getBirthDate();

        return directorDTO;
    }
}
