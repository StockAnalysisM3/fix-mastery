
package com.fixmastery.instrument.dao;

import com.fixmastery.instrument.model.Instrument;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//do i need autowiring?
@Component
public class InstrumentRepository {

    Map<String, Instrument> instrumentRepo = new HashMap<>();

    public Iterable<Instrument> getAll() {return instrumentRepo.values();}

    public Iterable<String> getAllIds() {return instrumentRepo.keySet();}

    public Instrument getInstrumentById(String id) {return instrumentRepo.get(id);}

}
