package com.fixmastery.mic.controller;

import com.fixmastery.errorshandlers.MapValidationErrorsService;
import com.fixmastery.mic.model.Country;
import com.fixmastery.mic.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private MapValidationErrorsService mapValidationErrorsService;

    @GetMapping("/size")
    public ResponseEntity<?> getCountriesSize() {
        long numOfOrders = countryService.getSize();
        return new ResponseEntity<Long>(numOfOrders, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllOrders() {
        Iterable<Country> allCountriess = countryService.getAllCountries();
        return new ResponseEntity<Iterable<Country>>(allCountriess, HttpStatus.OK);
    }

}
