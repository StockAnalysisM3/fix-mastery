package com.fixmastery.mic.dao;

import com.fixmastery.mic.dto.MarketInstitutionData;
import com.fixmastery.mic.model.Country;
import com.fixmastery.mic.model.MarketInstitution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class MicDataRepository {


    Map<String, MarketInstitution> micRepo = new HashMap<>();

    @Autowired
    public CountryRepository countryRepo;

    public void addNewMarketInstitution(MarketInstitution mic) {
        micRepo.put(mic.getId(), mic);
    }


//    public String getCountryId(MarketInstitution inputMic){
//        Collection<MarketInstitution> allMics = micRepo.values();
//        //MarketInstitution thisMic = allMics.stream().filter(mic->mic.getId().equals(inputMic.getId()));
//        return inputMic.getCountryId();
//    }

    public MarketInstitution addNewMicFromMarketInstitutionData(MarketInstitutionData data) {
        String countryId = countryRepo.getIdFromName(data.getCountry());
        MarketInstitution mic = new MarketInstitution();
        mic.setId(data.getId());
        mic.setName(data.getOperatingMic()); //getOperatingMic
        mic.setCountryId(countryId);
        mic.setAcronym(data.getAcronym());
        mic.setCity( data.getCity());
        mic.setWebsite(data.getWebsite());
        mic.setDescription(data.getWebsite());

        return mic;
    }

    public Iterable<MarketInstitution> getAll() {
        return micRepo.values();
    }


    public Iterable<String> getAllIds() {
        return micRepo.keySet();
    }

    public MarketInstitution getOrderById(String id) {
        return micRepo.get(id);
    }

    public void addNewMic(MarketInstitution mic) {
        micRepo.put(mic.getId(), mic);
    }

    public MarketInstitution getMicById(String id) {
        return micRepo.get(id);
    }
}
