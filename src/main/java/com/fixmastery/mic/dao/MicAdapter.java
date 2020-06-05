package com.fixmastery.mic.dao;


import com.fixmastery.mic.dto.MarketInstitutionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MicAdapter {
    @Autowired
    MicDataRepository micDataRepository;

    @Autowired
    MicRepository micRepository;

    public void adapt() {
        Iterable<MarketInstitutionData> allData = micDataRepository.findAll();
        allData.forEach(data -> micRepository.addNewMicFromMarketInstitutionData(data));
    }
}
