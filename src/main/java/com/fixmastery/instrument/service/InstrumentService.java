package com.fixmastery.instrument.service;

import com.fixmastery.instrument.dao.InstrumentDataRepository;
import com.fixmastery.instrument.dao.InstrumentRepository;
import com.fixmastery.instrument.model.Instrument;
import com.google.common.collect.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstrumentService {

    @Autowired
    InstrumentRepository instrumentRepo;

    public long getSize() {
        return Iterators.size(instrumentRepo.getAll().iterator());
    }

    public Optional<Instrument> getInstrumentById(String id) {
        return Optional.ofNullable(instrumentRepo.getInstrumentById(id));
    }

    public Iterable<Instrument> getAll() {
        return instrumentRepo.getAll();
    }

    public Iterable<String> getAllIds() {
        return instrumentRepo.getAllIds();
    }

//need add/update/delete?

}
