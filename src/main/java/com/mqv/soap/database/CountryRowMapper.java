package com.mqv.soap.database;

import io.vietmai.spring_java_course.Country;
import io.vietmai.spring_java_course.Currency;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRowMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        var country = new Country();
        country.setName(rs.getString("name"));
        country.setPopulation(rs.getBigDecimal("population").toBigInteger());
        country.setCapital(rs.getString("capital"));
        country.setCurrency(Currency.fromValue(rs.getString("currency")));
        return country;
    }
}
