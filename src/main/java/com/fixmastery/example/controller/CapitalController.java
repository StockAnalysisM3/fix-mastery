package com.fixmastery.example.controller;

import com.fixmastery.example.model.Capital;
import com.fixmastery.example.service.CapitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/capitals/")
public class CapitalController {

    @Autowired
    private CapitalService capitalService;

    @GetMapping("/")
    public ResponseEntity<?> getAll() throws Exception {
        Iterable<Capital> allCapitals = capitalService.getAllCapitals();
        return new ResponseEntity<Iterable<Capital>>(allCapitals, HttpStatus.OK);
    }

    @GetMapping("/size")
    public ResponseEntity<?> getSize() throws Exception {
        long size = capitalService.loadFromText();
        return new ResponseEntity<Long>(size, HttpStatus.OK);
    }

    @GetMapping("/byState/{state}")
    public ResponseEntity<?> getCapitalByState(@PathVariable String state) {
        Optional<Capital> capital = capitalService.getCapitalByState(state);
        return new ResponseEntity<Optional<Capital>>(capital, HttpStatus.OK);
    }

    @GetMapping("/limit/population/{limit}")
    public ResponseEntity<?> getCapitalsWithinPopulationLimit(@PathVariable String limit) {
        long longLimit = Long.parseLong(limit);
        Iterable<Capital> filteredCapitals = capitalService.getCapitalWithPopulationLimit(longLimit);
        return new ResponseEntity<Iterable<Capital>>(filteredCapitals, HttpStatus.OK);
    }

    @GetMapping("limit/squareMiles/{limit}")
    public ResponseEntity<?> getCapitalsWithinAreaLimit(@PathVariable String limit) {
        double doubleLimit = Double.parseDouble(limit);
        Iterable<Capital> filteredCapitals = capitalService.getCapitalWithAreaLimit(doubleLimit);
        return new ResponseEntity<Iterable<Capital>>(filteredCapitals, HttpStatus.OK);
    }
}
