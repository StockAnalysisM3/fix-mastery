package com.fixmastery;

import com.fixmastery.categories.dao.CategoryAdapter;
import com.fixmastery.orders.dao.OrderDataToModelsAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HomeCommandLineRunner implements CommandLineRunner {

    // TODO: Create and AutoWire InstrumentRepo

    @Autowired
    private OrderDataToModelsAdapter orderTradeMessageAdapter;

    @Override
    public void run(String... args) throws Exception {
        // TODO: Create the three order classes and associated repo
        // TODO: Use catRepo to load categories into the three order classes

        orderTradeMessageAdapter.adapt();
    }
}
