package com.elif.studioapp.data.configuration;


import com.elif.studioapp.data.BeanName;
import com.elif.studioapp.data.mapper.IDirectorMapper;
import com.elif.studioapp.data.mapper.IMovieMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(BeanName.MAPPER_CONFIG)
public class MapperConfig {
    @Bean(BeanName.MOVIE_MAPPER)
    public IMovieMapper getMovieMapper()
    {
        return Mappers.getMapper(IMovieMapper.class);
    }
    @Bean(BeanName.DIRECTOR_MAPPER)
    public IDirectorMapper getDirectorMapper()
    {
        return Mappers.getMapper(IDirectorMapper.class);
    }
}
