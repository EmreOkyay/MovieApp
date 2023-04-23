package com.elif.studioapp.data.mapper;

import com.elif.studioapp.data.entity.Director;
import com.elif.studioapp.data.entity.DirectorSave;
import com.karandev.util.mapstruct.IOptionalMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "DirectorMapperImpl")
public interface IDirectorMapper extends IOptionalMapper {
    @Mapping(source = "middleName", target = "middleNameOpt", qualifiedByName = "toOptional")
    @Mapping(source = "middleName", target = "middleName", ignore = true)
    Director toDirector(DirectorSave directorSave);
}
