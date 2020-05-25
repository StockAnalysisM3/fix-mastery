package com.fixmastery;

import com.fixmastery.categories.dao.CategoryMaps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HomeCommandLineRunner implements CommandLineRunner {

    @Autowired
    CategoryMaps catRepo;

    // TODO: Create and AutoWire InstrumentRepo


    @Override
    public void run(String... args) throws Exception {
        // TODO: Create the three order classes and associated repo
        // TODO: Use catRepo to load categories into the three order classes


    }
}
