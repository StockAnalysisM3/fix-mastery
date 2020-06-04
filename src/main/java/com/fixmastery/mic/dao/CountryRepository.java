package com.fixmastery.mic.dao;

import com.fixmastery.mic.model.Country;
import com.fixmastery.mic.dto.MarketInstitutionData;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class CountryRepository {
    Map<String, Country> countryRepo = new HashMap<>();

    public void addNewCountry(Country country){
        countryRepo.put(country.getId(), country);
    }

    public Country addNewCountryFromMIData(MarketInstitutionData data) {
        Country newCountry = new Country(
                data.getCountry(),
                data.getCountryCode()
        );
        addNewCountry(newCountry);
        return newCountry;
    }

    public Collection<Country> getAllCountries() {
        Collection<Country> allCountries = countryRepo.values();
        return allCountries;
    }

    public Iterable<Country> getAll() {
        return countryRepo.values();
    }

    public Iterable<String> getAllIds() {
        return countryRepo.keySet();
    }

    public Country getCountryById(String Id) {
        return countryRepo.get(Id);
    }

    public String getIdFromName(String countryName) {
        Collection<Country> allCountries = (List<Country>) this.getAllCountries();
        AtomicReference<Country> identifiedCountry = new AtomicReference<>();
        allCountries.stream().filter(country -> {
            if (Objects.equals(country.getName(), countryName)) return true;
            else return false;
        }).forEach(identifiedCountry::set);

        return identifiedCountry.get().getId();
    }

//    public Country getByMarketInstitutionId(String micId) {
//
//        //yet to do - check later whether we need this
//    }


}
