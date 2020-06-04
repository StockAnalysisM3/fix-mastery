package com.fixmastery.mic.dao;

import com.fixmastery.mic.model.Country;
import com.fixmastery.mic.dto.MarketInstitutionData;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


    public String getIdFromName(String countryName) {
        Collection<Country> allCountries = (List<Country>) this.getAllCountries();
        AtomicReference<Country> identifiedCountry = new AtomicReference<>();
        allCountries.forEach(country -> {
                if(country.getName().equals(countryName)){
                    identifiedCountry.set(country);
                  }
        });

        return identifiedCountry.get().getId();
    }

    public Country getByMarketInstitutionId(String micId) {
        Country newCountry = new Country();
        return newCountry;
        //yet to do - check later whether we need this
    }


}
