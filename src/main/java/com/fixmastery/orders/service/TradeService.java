package com.fixmastery.orders.service;

import com.fixmastery.orders.dao.modeldao.TradeCommandRepository;
import com.fixmastery.orders.model.TradeCommand;
import com.google.common.collect.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TradeService {

    @Autowired
    private TradeCommandRepository tradeCommandRepository;

    public long getTradesSize() {
        return Iterators.size(tradeCommandRepository.getAll().iterator());
    }

    public Iterable<TradeCommand> getAllTrades() {
        return tradeCommandRepository.getAll();
    }

    public Iterable<String> getAllTradeIds() {
        return tradeCommandRepository.getAllIds();
    }

    public Optional<TradeCommand> getTradeById(String id) {
        TradeCommand requestedTradeCommand = tradeCommandRepository.getTradeCommandById(id);
        return Optional.ofNullable(requestedTradeCommand);
    }

    public void addOrUpdateTrade(TradeCommand tradeCommand) {
        tradeCommandRepository.addNewTradeCommand(tradeCommand);
    }
}
