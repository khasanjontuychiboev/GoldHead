package com.akaxon.goldhead.city;

import com.akaxon.goldhead.country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    City findCityByName(String name) {
        String sql = "" +
                " select " +
                " name, " +
                " country_name, " +
                " created_at, " +
                " updated_at " +
                " from city " +
                " where LOWER(name)=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, getCityFromDb());

    }

    List<City> findCityByCountryName(String countryName){
        String sql = "" +
                " select " +
                " name, " +
                " country_name, " +
                " created_at, " +
                " updated_at " +
                " from city " +
                " where LOWER(country_name)=?";

        return jdbcTemplate.query(sql, new Object[]{countryName}, getCityByCountryNameFromDb());
    }


    private RowMapper<City> getCityFromDb() {
        return ((resultSet, i) ->
                new City(
                        resultSet.getString("name"),
                        resultSet.getString("country_name"),
                        resultSet.getDate("created_at").toLocalDate(),
                        resultSet.getDate("updated_at").toLocalDate()
                )
        );
    }

    private RowMapper<City> getCityByCountryNameFromDb() {
        return ((resultSet, i) ->
                new City(
                        resultSet.getString("name"),
                        resultSet.getString("country_name"),
                        resultSet.getDate("created_at").toLocalDate(),
                        resultSet.getDate("updated_at").toLocalDate()
                )
        );
    }


}
