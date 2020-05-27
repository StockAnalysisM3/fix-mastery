package com.fixmastery;

import com.fixmastery.orders.dao.OrderDataToModelsAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HomeCommandLineRunner implements CommandLineRunner {

    @Autowired
    private OrderDataToModelsAdapter orderTradeMessageAdapter;

    @Override
    public void run(String... args) throws Exception {
        orderTradeMessageAdapter.adapt();
    }
}
