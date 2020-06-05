package com.fixmastery.instrument.dao;

import com.fixmastery.instrument.dto.InstrumentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstrumentAdapter {
    @Autowired
    InstrumentDataRepository instrumentDataRepository;

    @Autowired
    InstrumentRepository instrumentRepository;

    public void adapt() {
        Iterable<InstrumentData> allData = instrumentDataRepository.findAll();
        allData.forEach(data -> instrumentRepository.addInstrumentFromData(data));
    }
}
