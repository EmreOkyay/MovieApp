package com.elif.studioapp.data.dal;

import com.elif.studioapp.data.BeanName;
import com.elif.studioapp.data.entity.Movie;
import com.elif.studioapp.data.entity.MovieSave;
import com.elif.studioapp.data.mapper.IMovieMapper;
import com.elif.studioapp.data.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(BeanName.MOVIE_SERVICE_HELPER)
public class MovieServiceHelper {
    private final IMovieRepository m_movieRepository;
    private final IMovieMapper m_movieMapper;

    public MovieServiceHelper(@Qualifier(BeanName.MOVIE_REPOSITORY) IMovieRepository movieRepository,
                              @Qualifier(BeanName.MOVIE_MAPPER) IMovieMapper movieMapper)
    {
        m_movieRepository = movieRepository;
        m_movieMapper = movieMapper;
    }

    public long count()
    {
        return m_movieRepository.count();
    }

    public Iterable<Movie> findMoviesByMonth(int month)
    {
        return m_movieRepository.findByMonth(month);
    }

    public Iterable<Movie> findMoviesByYear(int year)
    {
        return m_movieRepository.findByYear(year);
    }

    public Iterable<Movie> findMoviesByMonthAndYear(int month, int year)
    {
        return m_movieRepository.findByMonthAndYear(month, year);
    }

    public Iterable<Movie> findMoviesInBetween(int begin, int end)
    {
        return m_movieRepository.findMoviesInBetween(begin, end);
    }

    public Optional<Movie> findMoviesByDirectorId(Long id)
    {
        return m_movieRepository.findById(id);
    }

    public MovieSave saveMovie(MovieSave movieDTO)
    {
        m_movieRepository.save(m_movieMapper.toMovie(movieDTO));

        return movieDTO;
    }
}
