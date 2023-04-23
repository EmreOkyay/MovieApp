package org.cansu.app.service.studio.director.controller;

import org.cansu.app.service.studio.director.dto.DirectorSaveDTO;
import org.cansu.app.service.studio.director.service.DirectorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/directors")
public class DirectorController {
    private final DirectorService m_directorService;

    public DirectorController(DirectorService directorService)
    {
        m_directorService = directorService;
    }

    @PostMapping("director/save")
    public DirectorSaveDTO save(@RequestBody DirectorSaveDTO movieSave)
    {
        return m_directorService.saveMovie(movieSave);
    }
}
