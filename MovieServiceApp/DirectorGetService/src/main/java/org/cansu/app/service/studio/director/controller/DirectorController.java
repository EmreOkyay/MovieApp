package org.cansu.app.service.studio.director.controller;

import org.cansu.app.service.studio.director.dto.CountDTO;
import org.cansu.app.service.studio.director.dto.DirectorsDTO;
import org.cansu.app.service.studio.director.service.DirectorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/directors")
public class DirectorController {
    private DirectorService m_directorService;

    public DirectorController(DirectorService directorService)
    {
        m_directorService = directorService;
    }

    @GetMapping("director/count")
    public CountDTO count()
    {
        return m_directorService.countMovies();
    }

    @GetMapping("director/firstName")
    public DirectorsDTO findDirectorsByFirstName(@RequestParam("fin") String firstName)
    {
        return m_directorService.findDirectorsByFirstName(firstName);
    }

    @GetMapping("director/familyName")
    public DirectorsDTO findDirectorsByFamilyName(@RequestParam("fan") String familyName)
    {
        return m_directorService.findDirectorsByFamilyName(familyName);
    }

/*

        // director_id = 1 --> null
        // director_id = 1188 --> long veri tipi için geçersiz değer : Day of the Doctor, The //ALSO// Error:500

    @GetMapping("movie/find/director")
    public Optional<MovieDTO> findMoviesByDirectorId(@RequestParam("id") Long id)
    {
        return m_movieService.findMoviesByDirectorId(id);
    }
*/

}
