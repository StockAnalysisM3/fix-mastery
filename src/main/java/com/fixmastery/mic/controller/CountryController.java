package com.fixmastery.mic.controller;

import com.fixmastery.mic.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;



}
