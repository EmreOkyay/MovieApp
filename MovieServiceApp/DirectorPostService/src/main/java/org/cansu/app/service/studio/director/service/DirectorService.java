package org.cansu.app.service.studio.director.service;

import com.elif.studioapp.data.BeanName;
import com.elif.studioapp.data.dal.DirectorServiceHelper;
import org.cansu.app.service.studio.director.dto.DirectorSaveDTO;
import org.cansu.app.service.studio.director.mapper.IDirectorSaveMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {
    private final DirectorServiceHelper m_directorServiceHelper;
    private final IDirectorSaveMapper m_directorSaveMapper;

    public DirectorService(@Qualifier(BeanName.DIRECTOR_SERVICE_HELPER) DirectorServiceHelper directorServiceHelper,
                           IDirectorSaveMapper directorSaveMapper)
    {
        m_directorServiceHelper = directorServiceHelper;
        m_directorSaveMapper = directorSaveMapper;
    }

    public DirectorSaveDTO saveMovie(DirectorSaveDTO directorSaveDTO)
    {
        m_directorServiceHelper.saveDirector(m_directorSaveMapper.toDirectorSave(directorSaveDTO));

        return directorSaveDTO;
    }
}
