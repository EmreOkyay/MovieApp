package org.cansu.app.service.studio.movie.controller;

import org.cansu.app.service.studio.movie.dto.CountDTO;
import org.cansu.app.service.studio.movie.dto.MoviesDTO;
import org.cansu.app.service.studio.movie.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movies")
public class MovieController {
    private MovieService m_movieService;

    public MovieController(MovieService movieService)
    {
        m_movieService = movieService;
    }

    @GetMapping("movie/count")
    public CountDTO count()
    {
        return m_movieService.countMovies();
    }

    @GetMapping("movie/find/sdate/month")
    public MoviesDTO findByMonth(@RequestParam("m") int month)
    {
        return m_movieService.findMoviesByMonth(month);
    }

    @GetMapping("movie/find/sdate/year")
    public MoviesDTO findByYear(@RequestParam("y") int year)
    {
        return m_movieService.findMoviesByYear(year);
    }

    @GetMapping("movie/find/sdate/my")
    public MoviesDTO findByMonthAndYear(@RequestParam("m") int month, @RequestParam("y") int year)
    {
        return m_movieService.findMoviesByMonthAndYear(month, year);
    }

    @GetMapping("movie/find/sdate/year/between")
    public MoviesDTO findMoviesInBetween(@RequestParam("b") int begin, @RequestParam("e") int end)
    {
        return m_movieService.findMoviesInBetween(begin, end);
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
