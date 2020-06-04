package com.fixmastery.orders.dao.modeldao;

import com.fixmastery.orders.dto.RawOrderData;
import com.fixmastery.orders.model.TradeCommand;
import com.fixmastery.orders.model.TradeExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TradeExecutionRepository {

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

    public Iterable<TradeExecution> getAll(){
        return executionRepo.values();
    }

    public Iterable<String> getAllIds() {
        return executionRepo.keySet();
    }

    public TradeExecution getTradeExecutionById(String id){
        return executionRepo.get(id);
    }

    public Iterable<TradeExecution> getTradeExecutionsOfCommand(TradeCommand tradeCommand) {
        Collection<TradeExecution> tradeExecutions = executionRepo.values();
        Iterable<TradeExecution> executionsOfCommand = tradeExecutions
            .stream()
            .filter(exec -> exec.getCmdTradeId() == tradeCommand.getId())
            .collect(Collectors.toList());
        return executionsOfCommand;
    }

}
