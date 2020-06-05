
package com.fixmastery.instrument.dao;

import com.fixmastery.instrument.dto.InstrumentData;
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

    public Instrument addInstrumentFromData(InstrumentData data) {
        Instrument newInstrument = new Instrument(
            String.valueOf(data.getId()),
            data.getInstrument(),
            data.getRic(),
            data.getSedol(),
            data.getCusip(),
            data.getBbid(),
            data.getMic(),
            data.getName()
        );

        System.out.println(newInstrument.toString());
        instrumentRepo.put(newInstrument.getId(), newInstrument);

        return newInstrument;
    }

}
