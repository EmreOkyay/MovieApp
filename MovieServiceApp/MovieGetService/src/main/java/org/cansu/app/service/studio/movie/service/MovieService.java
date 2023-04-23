package org.cansu.app.service.studio.movie.service;

import com.elif.studioapp.data.BeanName;
import com.elif.studioapp.data.dal.MovieServiceHelper;
import org.cansu.app.service.studio.movie.dto.CountDTO;
import org.cansu.app.service.studio.movie.dto.MovieDTO;
import org.cansu.app.service.studio.movie.dto.MoviesDTO;
import org.cansu.app.service.studio.movie.mapper.IMovieMapper;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
    private final MovieServiceHelper m_movieServiceHelper;
    private final IMovieMapper m_movieMapper;

    public MovieService(@Qualifier(BeanName.MOVIE_SERVICE_HELPER) MovieServiceHelper movieServiceHelper,
                        IMovieMapper movieMapper)
    {
        m_movieServiceHelper = movieServiceHelper;
        m_movieMapper = movieMapper;
    }

    public CountDTO countMovies()
    {
        return m_movieMapper.toCountDTO(m_movieServiceHelper.count());
    }

    public MoviesDTO findMoviesByMonth(int month)
    {
        return m_movieMapper.toMoviesDTO(CollectionUtil.toList(m_movieServiceHelper.findMoviesByMonth(month), m_movieMapper::toMovieDTO));
    }

    public MoviesDTO findMoviesByYear(int year)
    {
        return m_movieMapper.toMoviesDTO(CollectionUtil.toList(m_movieServiceHelper.findMoviesByYear(year), m_movieMapper::toMovieDTO));
    }

    public MoviesDTO findMoviesByMonthAndYear(int month, int year)
    {
        return m_movieMapper.toMoviesDTO(CollectionUtil.toList(m_movieServiceHelper.findMoviesByMonthAndYear(month, year), m_movieMapper::toMovieDTO));
    }

    public MoviesDTO findMoviesInBetween(int begin, int end)
    {
        return m_movieMapper.toMoviesDTO(CollectionUtil.toList(m_movieServiceHelper.findMoviesInBetween(begin, end), m_movieMapper::toMovieDTO));
    }

    public Optional<MovieDTO> findMoviesByDirectorId(Long id)
    {
        return m_movieServiceHelper.findMoviesByDirectorId(id).map(m_movieMapper::toMovieDTO);
    }
}
