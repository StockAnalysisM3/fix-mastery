package com.fixmastery;

import com.fixmastery.instrument.dao.InstrumentAdapter;
import com.fixmastery.orders.dao.adapter.DataToModelsAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HomeCommandLineRunner implements CommandLineRunner {

    @Autowired
    private DataToModelsAdapter orderTradeMessageAdapter;

    @Autowired
    private InstrumentAdapter instrumentAdapter;

    @Override
    public void run(String... args) throws Exception {
        orderTradeMessageAdapter.adapt();
        instrumentAdapter.adapt();
    }
}
