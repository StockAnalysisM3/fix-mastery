package com.fixmastery;

import com.fixmastery.categories.dao.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HomeCommandLineRunner implements CommandLineRunner {

    @Autowired
    CategoryRepository catRepo;

    // TODO: Create and AutoWire InstrumentRepo


    @Override
    public void run(String... args) throws Exception {
        // TODO: Use catRepo to load statuses into the three order classes

        
    }
}
