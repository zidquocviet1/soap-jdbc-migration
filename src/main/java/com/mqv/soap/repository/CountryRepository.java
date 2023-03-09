package com.mqv.soap.repository;

import io.vietmai.spring_java_course.Country;

import java.util.Optional;

public interface CountryRepository {
    Country findByName(String name);

    Optional<Country> findById(int id);
}
