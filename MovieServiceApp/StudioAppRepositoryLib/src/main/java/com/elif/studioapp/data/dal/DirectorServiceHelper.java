package com.elif.studioapp.data.dal;

import com.elif.studioapp.data.BeanName;
import com.elif.studioapp.data.entity.Director;
import com.elif.studioapp.data.entity.DirectorSave;
import com.elif.studioapp.data.mapper.IDirectorMapper;
import com.elif.studioapp.data.repository.IDirectorRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(BeanName.DIRECTOR_SERVICE_HELPER)
public class DirectorServiceHelper {
    private final IDirectorRepository m_directorRepository;
    private final IDirectorMapper m_directorMapper;

    public DirectorServiceHelper(@Qualifier(BeanName.DIRECTOR_REPOSITORY) IDirectorRepository directorRepository,
                                 @Qualifier(BeanName.DIRECTOR_MAPPER) IDirectorMapper directorMapper)
    {
        m_directorRepository = directorRepository;
        m_directorMapper = directorMapper;
    }

    public long count()
    {
        return m_directorRepository.count();
    }

    public Iterable<Director> findDirectorsByFirstName(String firstName)
    {
        return m_directorRepository.findDirectorsByFirstName(firstName);
    }

    public Iterable<Director> findDirectorsByFamilyName(String familyName)
    {
        return m_directorRepository.findDirectorsByFamilyName(familyName);
    }

    public DirectorSave saveDirector(DirectorSave directorDTO)
    {
        m_directorRepository.save(m_directorMapper.toDirector(directorDTO));

        return directorDTO;
    }
}
