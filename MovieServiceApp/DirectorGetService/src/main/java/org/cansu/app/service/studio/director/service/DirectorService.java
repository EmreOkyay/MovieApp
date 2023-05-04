package org.cansu.app.service.studio.director.service;

import com.elif.studioapp.data.BeanName;
import com.elif.studioapp.data.dal.DirectorServiceHelper;
import org.cansu.app.service.studio.director.dto.CountDTO;
import org.cansu.app.service.studio.director.dto.DirectorsDTO;
import org.cansu.app.service.studio.director.mapper.IDirectorMapper;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {
    private final DirectorServiceHelper m_directorServiceHelper;
    private final IDirectorMapper m_directorMapper;

    public DirectorService(@Qualifier(BeanName.DIRECTOR_SERVICE_HELPER) DirectorServiceHelper directorServiceHelper,
                           IDirectorMapper directorMapper)
    {
        m_directorServiceHelper = directorServiceHelper;
        m_directorMapper = directorMapper;
    }

    public CountDTO countMovies()
    {
        return m_directorMapper.toCountDTO(m_directorServiceHelper.count());
    }

    public DirectorsDTO findDirectorsByFirstName(String firstName)
    {
        return m_directorMapper.toDirectorsDTO(CollectionUtil.toList(m_directorServiceHelper.findDirectorsByFirstName(firstName), m_directorMapper::toDirectorDTO));
    }

    public DirectorsDTO findDirectorsByFamilyName(String familyName)
    {
        return m_directorMapper.toDirectorsDTO(CollectionUtil.toList(m_directorServiceHelper.findDirectorsByFamilyName(familyName), m_directorMapper::toDirectorDTO));
    }
}
