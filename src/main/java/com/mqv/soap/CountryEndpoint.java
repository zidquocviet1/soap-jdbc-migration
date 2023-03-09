package com.mqv.soap;

import com.mqv.soap.repository.CountryRepository;
import io.vietmai.spring_java_course.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigInteger;

@Endpoint
public class CountryEndpoint {
    private final CountryRepository countryRepository;

    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @ResponsePayload
    @PayloadRoot(localPart = "getCountryRequest", namespace = "http://vietmai.io/spring-java-course")
    public GetCountryResponse getCountryByName(@RequestPayload GetCountryRequest request) {
        var countryResponse = new GetCountryResponse();
        var country = new Country();
        country.setName("Viet Nam");
        country.setPopulation(BigInteger.valueOf(980000000000L));
        country.setCapital("Ha Noi");
        country.setCurrency(Currency.VND);
        countryResponse.setCountry(country);
        return countryResponse;
    }

    @ResponsePayload
    @PayloadRoot(localPart = "getCountryById", namespace = "http://vietmai.io/spring-java-course")
    public GetCountryResponse getCountryById(@RequestPayload GetCountryById countryId) {
        var country = countryRepository.findById(countryId.getId());
        if (country.isPresent()) {
            var response = new GetCountryResponse();
            response.setCountry(country.get());
            return response;
        }
        return null;
    }
}
