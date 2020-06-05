package com.fixmastery.instrument.controller;

import com.fixmastery.instrument.model.Instrument;
import com.fixmastery.instrument.service.InstrumentService;
import com.fixmastery.mic.model.MarketInstitution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import com.fixmastery.errorshandlers.MapValidationErrorsService;

import java.util.Iterator;
import java.util.Optional;

@Controller
@RequestMapping("/api/instruments/")
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    @Autowired
    private MapValidationErrorsService mapValidationErrorsService;

    @GetMapping("/size")
    public ResponseEntity<?> getInstrumentSize(){
        long numOfInstrument = instrumentService.getSize();
        return new ResponseEntity<Long>(numOfInstrument, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllInstruments() {
        Iterable<Instrument> allInstruments = instrumentService.getAll();
        return new ResponseEntity<Iterable<Instrument>>(allInstruments, HttpStatus.OK);
    }

    @GetMapping("/idset")
    public ResponseEntity<?> getAllInstrumentIds() {
        Iterable<String> allIds = instrumentService.getAllIds();
        return new ResponseEntity<Iterable<String>>(allIds, HttpStatus.OK);
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<?> getInstrumentById(@PathVariable String id) {
        Optional<Instrument> instrument = instrumentService.getInstrumentById(id);
        return new ResponseEntity<Optional<Instrument>>(instrument, HttpStatus.OK);
    }

    @GetMapping("/traded")
    public ResponseEntity<?> getInstrumentsThatHaveTradingActivity() {
        Iterable<Instrument> allInstrumentsWithTradingActivity = instrumentService.getInstrumentsThatAreTraded();
        return new ResponseEntity<Iterable<Instrument>>(allInstrumentsWithTradingActivity, HttpStatus.OK);
    }

/*
    @PostMapping("/")
    public ResponseEntity<?> addOrUpdateOrder(@RequestBody MarketInstitution mic, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorsService.MapValidationErrorsService(result);

        if(errorMap != null) {
            return errorMap;
        }

        micService.addOrUpdateNewMic(mic);

        return new ResponseEntity<MarketInstitution>(mic, HttpStatus.OK);
*/
}
