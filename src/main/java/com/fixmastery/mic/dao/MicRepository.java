package com.fixmastery.mic.dao;

import com.fixmastery.mic.dto.MarketInstitutionData;
import com.fixmastery.mic.model.Country;
import com.fixmastery.mic.model.MarketInstitution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class MicRepository {

    Map<String, MarketInstitution> micRepo = new HashMap<>();

    @Autowired
    public CountryRepository countryRepo;

    public void addNewMarketInstitution(MarketInstitution mic) {
        micRepo.put(mic.getId(), mic);
    }

    public MarketInstitution addNewMicFromMarketInstitutionData(MarketInstitutionData data) {
        //String countryId = countryRepo.getIdFromName(data.getCountry());
        //both repos are not loaded concurrently -> we ll do this later
        MarketInstitution mic = new MarketInstitution();
        mic.setId(data.getId());
        //mic.setName(data.getOperatingMic()); //getOperatingMic - Fix this later
        mic.setCountryId(data.getCountryCode());//changed from id to country code
        mic.setAcronym(data.getAcronym());
        mic.setCity( data.getCity());
        mic.setWebsite(data.getWebsite());
        mic.setDescription(data.getWebsite());
        micRepo.put(mic.getId(), mic);
        return mic;
    }

    public Iterable<MarketInstitution> getAll() {
        return micRepo.values();
    }

    public Iterable<String> getAllIds() {
        return micRepo.keySet();
    }

    public void addNewMic(MarketInstitution mic) {
        micRepo.put(mic.getId(), mic);
    }

    public MarketInstitution getMicById(String id) {
        return micRepo.get(id);
    }
}
