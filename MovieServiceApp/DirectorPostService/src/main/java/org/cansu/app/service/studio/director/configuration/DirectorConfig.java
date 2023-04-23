package org.cansu.app.service.studio.director.configuration;

import com.elif.studioapp.data.mapper.IDirectorMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DirectorConfig {
    @Bean
    @Primary
    public IDirectorMapper getMapper()
    {
        return Mappers.getMapper(IDirectorMapper.class);
    }
}
