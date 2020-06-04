package com.fixmastery.mic.service;

import com.fixmastery.mic.dao.MicDataRepository;
import com.fixmastery.mic.model.MarketInstitution;
import com.google.common.collect.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarketInstitutionService {
    @Autowired
    MicDataRepository micRepo;



    public long getSize() {
        return Iterators.size(micRepo.getAll().iterator());
    }

    public Optional<MarketInstitution> getMicById(String id) {
        return Optional.ofNullable(micRepo.getMicById(id));
    }

    public Iterable<MarketInstitution> getAllMics() {
        return micRepo.getAll();
    }

    public Iterable<String> getAllMicIds() {
        return micRepo.getAllIds();
    }

    public void addOrUpdateNewMic(MarketInstitution mic) {
        micRepo.addNewMic(mic);
    }
}
