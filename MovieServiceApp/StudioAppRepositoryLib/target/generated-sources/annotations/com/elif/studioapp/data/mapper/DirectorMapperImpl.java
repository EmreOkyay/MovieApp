package com.elif.studioapp.data.mapper;

import com.elif.studioapp.data.entity.Director;
import com.elif.studioapp.data.entity.DirectorSave;
import com.karandev.util.mapstruct.IOptionalMapper;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-05T02:41:54+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class DirectorMapperImpl implements IDirectorMapper {

    @Override
    public Director toDirector(DirectorSave directorSave) {
        if ( directorSave == null ) {
            return null;
        }

        Director director = new Director();

        director.setMiddleNameOpt( IOptionalMapper.toOptional( directorSave.middleName ) );
        director.setDirectorId( directorSave.directorId );
        director.setFirstName( directorSave.firstName );
        director.setFamilyName( directorSave.familyName );
        director.setBirthDate( directorSave.birthDate );

        return director;
    }
}
