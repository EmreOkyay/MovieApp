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
    private static final String COUNT_SQL = "select count(*) from directors";
    private static final String SAVE_SQL = "call sp_insert_director(:directorNo, :firstName, :middleName, :familyName, :birthDate)";
    private static final String FIND_BY_FIRST_NAME_SQL = "select * from directors where first_name = :firstName";
    private static final String FIND_BY_FAMILY_NAME_SQL = "select * from directors where family_name = :familyName";

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
    public long count()
    {
        var counts = new ArrayList<Long>();

        m_namedParameterJdbcTemplate.query(COUNT_SQL, rs -> {counts.add(rs.getLong(1));});

        return counts.get(0);
    }

    @Override
    public Iterable<Director> findDirectorsByFirstName(String firstName)
    {
        var paramMap = new HashMap<String, Object>();
        var directors = new ArrayList<Director>();

        paramMap.put("firstName", firstName);

        m_namedParameterJdbcTemplate.query(FIND_BY_FIRST_NAME_SQL, paramMap, (ResultSet rs) -> fillDirectors(rs, directors));

        return directors;
    }

    @Override
    public Iterable<Director> findDirectorsByFamilyName(String familyName)
    {
        var paramMap = new HashMap<String, Object>();
        var directors = new ArrayList<Director>();

        paramMap.put("familyName", familyName);

        m_namedParameterJdbcTemplate.query(FIND_BY_FAMILY_NAME_SQL, paramMap,(ResultSet rs) -> fillDirectors(rs, directors));

        return directors;
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
    public Optional<Director> findById(Long aLong) {
        throw new UnsupportedOperationException();
    }

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
