package com.elif.studioapp.data.repository;

import com.elif.studioapp.data.BeanName;
import com.elif.studioapp.data.entity.Director;
import com.elif.studioapp.data.mapper.IDirectorMapper;
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

@Repository(BeanName.DIRECTOR_REPOSITORY)
public class DirectorRepository implements IDirectorRepository {
    private static final String FIND_BY_MOVIE_ID = "select * from get_directors_by_movie_id(:id)";
    private static final String SAVE_SQL = "call sp_insert_director(:directorNo, :firstName, :middleName, :familyName, :birthDate)";

    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;
    private final IDirectorMapper m_directorMapper;

    public DirectorRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                              @Qualifier(BeanName.DIRECTOR_MAPPER) IDirectorMapper directorMapper)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        m_directorMapper = directorMapper;
    }

    private static Director getDirector(ResultSet rs) throws SQLException
    {
        var directorId = rs.getLong(1);
        var firstName = rs.getString(2);
        var middleName = Optional.ofNullable(rs.getString(3));
        var familyName = rs.getString(4);
        var birthDate = rs.getDate(5).toLocalDate();

        return new Director(directorId, firstName, middleName, familyName, birthDate);
    }

    private static void fillDirectors(ResultSet rs, List<Director> directors) throws SQLException
    {
        do
            directors.add(getDirector(rs));
        while (rs.next());
    }

    @Override
    public Optional<Director> findById(Long id)
    {
        var paramMap = new HashMap<String, Object>();
        var directors = new ArrayList<Director>();

        paramMap.put("id", id);

        m_namedParameterJdbcTemplate.query(FIND_BY_MOVIE_ID, paramMap, (ResultSet rs) -> fillDirectors(rs, directors));

        return directors.isEmpty() ? Optional.empty() : Optional.of(directors.get(0));
    }

    @Override
    public <S extends Director> S save(S director)
    {
        var paramSource = new BeanPropertySqlParameterSource(director);

        paramSource.registerSqlType("sceneDate", Types.DATE);
        m_namedParameterJdbcTemplate.update(SAVE_SQL, paramSource);

        return director;
    }

    // ---------------------------------------------------------------------------- //

    @Override
    public void deleteAll() {
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
    public long count() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Director entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Director> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Director> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Director> findAllById(Iterable<Long> id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Director> Iterable<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException();
    }
}
