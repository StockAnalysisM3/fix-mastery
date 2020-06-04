package com.fixmastery.orders.service;

import com.fixmastery.orders.dao.modeldao.TradeCommandRepository;
import com.fixmastery.orders.dao.modeldao.TradeExecutionRepository;
import com.fixmastery.orders.model.TradeCommand;
import com.fixmastery.orders.model.TradeExecution;
import com.google.common.collect.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TradeService {

    @Autowired
    private TradeCommandRepository tradeCommandRepository;

    @Autowired
    private TradeExecutionRepository tradeExecutionRepository;

    // Command

    public long getTradeCommandsSize() {
        return Iterators.size(tradeCommandRepository.getAll().iterator());
    }

    public Iterable<TradeCommand> getAllTradeCommands() {
        return tradeCommandRepository.getAll();
    }

    public Iterable<String> getAllTradeCommandIds() {
        return tradeCommandRepository.getAllIds();
    }

    public Optional<TradeCommand> getTradeCommandById(String id) {
        TradeCommand requestedTradeCommand = tradeCommandRepository.getTradeCommandById(id);
        return Optional.ofNullable(requestedTradeCommand);
    }

    public void addOrUpdateTradeCommand(TradeCommand tradeCommand) {
        tradeCommandRepository.addNewTradeCommand(tradeCommand);
    }

    // Execution

    public long getTradeExecutionsSize() {
        return Iterators.size(tradeExecutionRepository.getAll().iterator());
    }

    public Iterable<TradeExecution> getAllTradeExecutions() {
        return tradeExecutionRepository.getAll();
    }

    public Optional<TradeExecution> getTradeExecutionById(String id) {
        TradeExecution requestedTradeExecution = tradeExecutionRepository.getTradeExecutionById(id);
        return Optional.ofNullable(requestedTradeExecution);
    }

    public Iterable<TradeExecution> getTradeExecutionsFromCommand(TradeCommand tradeCommand) {
        return tradeExecutionRepository.getTradeExecutionsOfCommand(tradeCommand);
    }

}
