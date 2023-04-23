package org.cansu.app.service.studio.movie.service;

import com.elif.studioapp.data.BeanName;
import com.elif.studioapp.data.dal.MovieServiceHelper;
import org.cansu.app.service.studio.movie.dto.MovieSaveDTO;
import org.cansu.app.service.studio.movie.mapper.IMovieSaveMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieServiceHelper m_movieServiceHelper;
    private final IMovieSaveMapper m_movieSaveMapper;

    public MovieService(@Qualifier(BeanName.MOVIE_SERVICE_HELPER) MovieServiceHelper movieServiceHelper,
                        IMovieSaveMapper movieSaveMapper)
    {
        m_movieServiceHelper = movieServiceHelper;
        m_movieSaveMapper = movieSaveMapper;
    }

    public MovieSaveDTO saveMovie(MovieSaveDTO movieSaveDTO)
    {
        m_movieServiceHelper.saveMovie(m_movieSaveMapper.toMovieSave(movieSaveDTO));

        return movieSaveDTO;
    }
}
