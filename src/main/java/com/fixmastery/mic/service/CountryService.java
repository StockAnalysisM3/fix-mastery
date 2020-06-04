package com.fixmastery.mic.service;

import com.fixmastery.mic.dao.CountryRepository;
import com.fixmastery.mic.model.Country;
import com.google.common.collect.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepo;

    public long getSize() {
        return Iterators.size(countryRepo.getAllCountries().iterator());
    }

    public Optional<Country> getOrderById(String id) {
        return Optional.ofNullable(countryRepo.getCountryById(id));
    }

    public Iterable<Country> getAllCountries() {
        return countryRepo.getAll();
    }

    public Iterable<String> getAllCountryIds() {
        return countryRepo.getAllIds();
    }

    public void addOrUpdateNewOrder(Country country) {
        countryRepo.addNewCountry(country);
    }


}
