package com.fixmastery.instrument.service;

import com.fixmastery.instrument.dao.InstrumentRepository;
import com.fixmastery.instrument.model.Instrument;
import com.fixmastery.orders.dao.modeldao.TradeExecutionRepository;
import com.fixmastery.orders.model.TradeExecution;
import com.google.common.collect.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InstrumentService {

    @Autowired
    InstrumentRepository instrumentRepo;

    @Autowired
    TradeExecutionRepository tradeExecutionRepository;

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

    public Iterable<Instrument> getInstrumentsThatAreTraded() {
        Iterable<TradeExecution> allTradeExecutions = tradeExecutionRepository.getAll();
        Iterable<Instrument> allInstruments = instrumentRepo.getAll();

        List<String> allInstrumentsTraded = StreamSupport.stream(allTradeExecutions.spliterator(), false)
            .mapToInt(exec -> exec.getInstrumentId())
            .boxed()
            .map(instrumentId -> Integer.toString(instrumentId))
            .collect(Collectors.toList());

        Iterable<Instrument> allInstrumentsWithTradingActivity = StreamSupport.stream(allInstruments.spliterator(), false)
            .filter(inst -> allInstrumentsTraded.contains(inst.getId()))
            .collect(Collectors.toList());
        return allInstrumentsWithTradingActivity;
    }

//need add/update/delete?

}
