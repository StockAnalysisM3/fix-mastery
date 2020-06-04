package com.fixmastery.mic.controller;

import com.fixmastery.mic.model.MarketInstitution;
import com.fixmastery.mic.service.MarketInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import com.fixmastery.errorshandlers.MapValidationErrorsService;

import java.util.Optional;

@Controller
@RequestMapping("/api/mics")
public class MarketInstitutionController {

    @Autowired
    private MarketInstitutionService micService;

    @Autowired
    private MapValidationErrorsService mapValidationErrorsService;

    @GetMapping("/size")
    public ResponseEntity<?> getMicSize() {
        long numOfMic = micService.getSize();
        return new ResponseEntity<Long>(numOfMic, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllOrders() {
        Iterable<MarketInstitution> allOrders = MarketInstitutionService.getAllMics();
        return new ResponseEntity<Iterable<MarketInstitution>>(allOrders, HttpStatus.OK);
    }

    @GetMapping("/idset")
    public ResponseEntity<?> getAllMicsIds() {
        Iterable<String> allIds = MarketInstitutionService.getAllMicIds();
        return new ResponseEntity<Iterable<String>>(allIds, HttpStatus.OK);
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<?> getMicById(@PathVariable String id) {
        Optional<MarketInstitution> order = MarketInstitutionService.getMicById(id);
        return new ResponseEntity<Optional<MarketInstitution>>(order, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addOrUpdateOrder(@RequestBody MarketInstitution mic, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorsService.MapValidationErrorsService(result);

        if(errorMap != null) {
            return errorMap;
        }

        MarketInstitutionService.addOrUpdateNewMic(mic);

        return new ResponseEntity<MarketInstitution>(mic, HttpStatus.OK);
    }

}
