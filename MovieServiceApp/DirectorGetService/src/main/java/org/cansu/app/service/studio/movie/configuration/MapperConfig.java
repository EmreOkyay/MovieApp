package org.cansu.app.service.studio.movie.configuration;

import org.cansu.app.service.studio.movie.mapper.IMovieMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MapperConfig {
    @Bean
    @Primary
    public IMovieMapper getMapper()
    {
        return Mappers.getMapper(IMovieMapper.class);
    }
}
