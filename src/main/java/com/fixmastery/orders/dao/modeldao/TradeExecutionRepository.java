package com.fixmastery.orders.dao.modeldao;

import com.fixmastery.orders.dto.RawOrderData;
import com.fixmastery.orders.model.TradeCommand;
import com.fixmastery.orders.model.TradeExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TradeExecutionRepository {

    @Autowired
    TradeCommandRepository commandRepo;

    Map<String, TradeExecution> executionRepo = new HashMap<>();

    public void addNewTradeExecution(TradeExecution tradeExecution) {
        executionRepo.put(tradeExecution.getId(), tradeExecution);
    }

    public TradeExecution addNewTradeExecutionFromOrderData(RawOrderData data) {
        TradeExecution newTradeExecution = new TradeExecution(
            data.getInstanceId(),
            data.getParentId(),
            data.getInstrument(),
            data.getInitialQuantity(),
            data.getPrice()
        );

        addNewTradeExecution(newTradeExecution);
        return newTradeExecution;
    }

    // update parent?
}
