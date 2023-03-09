package com.mqv.soap.repository.impl;

import com.mqv.soap.database.CountryRowMapper;
import com.mqv.soap.repository.CountryRepository;
import io.vietmai.spring_java_course.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CountryRepositoryImpl implements CountryRepository {
    private static final Logger logger = LoggerFactory.getLogger(CountryRepository.class);

    private final JdbcTemplate jdbcTemplate;
    private final CountryRowMapper countryRowMapper;

    public CountryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.countryRowMapper = new CountryRowMapper();
    }

    @Override
    public Country findByName(String name) {
        var findByNameQuery = """
                SELECT id, name, population, currency
                 FROM country
                  WHERE name = ?
                """;
        try {
            return jdbcTemplate.query(findByNameQuery, countryRowMapper, name)
                    .stream()
                    .findFirst()
                    .orElse(null);
        } catch (DataAccessException e) {
            logger.error("Error occurred while getting country by name with name is: {}, exception: {}", name, e.getMessage());
            return null;
        }
    }

    @Override
    public Optional<Country> findById(int id) {
        var query = """
                SELECT id, name, population, currency
                FROM country
                WHERE id = 1
                """;
        return jdbcTemplate.query(query, countryRowMapper, id)
                .stream()
                .findFirst();
    }
}
