package org.cansu.app.service.studio.movie.controller;

import org.cansu.app.service.studio.movie.dto.MovieSaveDTO;
import org.cansu.app.service.studio.movie.service.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/movies")
public class MovieController {
    private final MovieService m_movieService;

    public MovieController(MovieService movieService)
    {
        m_movieService = movieService;
    }

    @PostMapping("movie/save")
    public MovieSaveDTO save(@RequestBody MovieSaveDTO movieSave)
    {
        return m_movieService.saveMovie(movieSave);
    }
}
