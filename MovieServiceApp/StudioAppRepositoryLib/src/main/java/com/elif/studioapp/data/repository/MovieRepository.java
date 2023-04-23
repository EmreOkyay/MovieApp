package com.elif.studioapp.data.repository;

import com.elif.studioapp.data.BeanName;
import com.elif.studioapp.data.entity.Movie;
import com.elif.studioapp.data.mapper.IMovieMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository(BeanName.MOVIE_REPOSITORY)
public class MovieRepository implements IMovieRepository {
    private static final String COUNT_SQL = "select count(*) from movies";
    private static final String FIND_BY_MONTH = "select * from movies where date_part('month', scene_date) = :month";
    private static final String FIND_BY_YEAR = "select * from movies where date_part('year', scene_date) = :year";
    private static final String FIND_BY_MONTH_AND_YEAR = """
            select * from movies where date_part('month', scene_date) = :month \s
            and date_part('year', scene_date) = :year""";
    private static final String FIND_IN_BETWEEN_YEARS = """
            select * from movies where :begin < date_part('year', scene_date)\s
            and date_part('year', scene_date) < :end""";
    private static final String FIND_BY_DIRECTOR_ID = "select * from get_movies_by_director_id(:id)";
    private static final String SAVE_SQL = """
            insert into movies (name, scene_date, rating, cost, imdb) values (:name, :sceneDate, :rating, :cost, :imdb)
            """;


    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;
    private final IMovieMapper m_movieMapper;

    public MovieRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                           @Qualifier(BeanName.MOVIE_MAPPER) IMovieMapper movieMapper)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        m_movieMapper = movieMapper;
    }

    private static Movie getMovie(ResultSet rs) throws SQLException
    {
        var movieId = rs.getLong(1);
        var name = rs.getString(2);
        var sceneDate = rs.getDate(3).toLocalDate();
        var rating = rs.getInt(4);
        var cost = rs.getDouble(5);
        var imdb = rs.getFloat(6);

        return new Movie(movieId, name, sceneDate, rating, cost, imdb);
    }

    private static void fillMovies(ResultSet rs, List<Movie> movies) throws SQLException
    {
        do
            movies.add(getMovie(rs));
        while (rs.next());
    }

    @Override
    public long count()
    {
        var counts = new ArrayList<Long>();

        m_namedParameterJdbcTemplate.query(COUNT_SQL, rs -> {counts.add(rs.getLong(1));});

        return counts.get(0);
    }
    @Override
    public Iterable<Movie> findByMonth(int month)
    {
        var paramMap = new HashMap<String, Object>();
        var movies = new ArrayList<Movie>();

        paramMap.put("month", month);

        m_namedParameterJdbcTemplate.query(FIND_BY_MONTH, paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;
    }

    @Override
    public Iterable<Movie> findByYear(int year)
    {
        var paramMap = new HashMap<String, Object>();
        var movies = new ArrayList<Movie>();

        paramMap.put("year", year);

        m_namedParameterJdbcTemplate.query(FIND_BY_YEAR, paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;
    }

    @Override
    public Iterable<Movie> findByMonthAndYear(int month, int year)
    {
        var paramMap = new HashMap<String, Object>();
        var movies = new ArrayList<Movie>();

        paramMap.put("month", month);
        paramMap.put("year", year);

        m_namedParameterJdbcTemplate.query(FIND_BY_MONTH_AND_YEAR, paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;
    }

    @Override
    public Iterable<Movie> findMoviesInBetween(int begin, int end) {
        var paramMap = new HashMap<String, Object>();
        var movies = new ArrayList<Movie>();

        paramMap.put("begin", begin);
        paramMap.put("end", end);

        m_namedParameterJdbcTemplate.query(FIND_IN_BETWEEN_YEARS, paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;
    }
    @Override
    public Optional<Movie> findById(Long id)
    {
        var paramMap = new HashMap<String, Object>();
        var movies = new ArrayList<Movie>();

        paramMap.put("id", id);

        m_namedParameterJdbcTemplate.query(FIND_BY_DIRECTOR_ID, paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies.isEmpty() ? Optional.empty() : Optional.of(movies.get(0));
    }


    @Override
    public <S extends Movie> S save(S movie)
    {
        var paramSource = new BeanPropertySqlParameterSource(movie);

        paramSource.registerSqlType("sceneDate", Types.DATE);
        m_namedParameterJdbcTemplate.update(SAVE_SQL, paramSource);

        return movie;
    }

    // ---------------------------------------------------------------------------- //


    @Override
    public void delete(Movie entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Movie> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException();
    }
}
