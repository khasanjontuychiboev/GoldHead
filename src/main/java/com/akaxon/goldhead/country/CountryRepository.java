package com.akaxon.goldhead.country;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class CountryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CountryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<Country> findAllCountry(){
        String sql = "" +
                " select " +
                " name, " +
                " created_at, " +
                " updated_at " +
                " from country";
        return jdbcTemplate.query(sql, getCountryRowMapper());
    }

    private RowMapper<Country> getCountryRowMapper(){
        return (resultSet, i) ->{
            String name = resultSet.getString("name");
            LocalDate createdAt = resultSet.getDate("created_at").toLocalDate();
            LocalDate updatedAt = resultSet.getDate("updated_at").toLocalDate();
            return new Country(name,
                    createdAt,
                    updatedAt);
        };
    }

    Country findCountryByName(String name) {
        String sql = "" +
                " select " +
                " name, " +
                " created_at, " +
                " updated_at " +
                " from country " +
                " where LOWER(name)=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, getCountryFromDb());

    }


    private RowMapper<Country> getCountryFromDb() {
        return ((resultSet, i) ->
                new Country(
                        resultSet.getString("name"),
                        resultSet.getDate("created_at").toLocalDate(),
                        resultSet.getDate("updated_at").toLocalDate()
                )
        );
    }

    int insertCountry(Country country){
        String sql = ""+
                "INSERT INTO " +
                " country( " +
                " name, " +
                " created_at, " +
                " updated_at) " +
                " VALUES(?,?,?) ";
        return jdbcTemplate.update(
                sql,
                country.getName(),
                country.getCreatedAt(),
                country.getUpdatedAt()
        );

    }







}
