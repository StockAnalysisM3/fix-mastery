package com.fixmastery.example.controller;

import com.fixmastery.example.service.CapitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * The CommandLineRunner will run the loadFromText service upon initialization
 */
@Profile("!test")
@Component
public class CapitalCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CapitalService capitalService;

    @Override
    public void run(String... args) throws Exception {
        capitalService.loadFromText();
    }
}
