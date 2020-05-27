package com.fixmastery.orders.service;

import com.fixmastery.orders.dao.modeldao.TradeRepository;
import com.fixmastery.orders.model.Trade;
import com.google.common.collect.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    public long getTradesSize() {
        return Iterators.size(tradeRepository.getAll().iterator());
    }

    public Iterable<Trade> getAllTrades() {
        return tradeRepository.getAll();
    }

    public Iterable<String> getAllTradeIds() {
        return tradeRepository.getAllIds();
    }

    public Optional<Trade> getTradeById(String id) {
        Trade requestedTrade = tradeRepository.getTradeById(id);
        return Optional.ofNullable(requestedTrade);
    }

    public void addOrUpdateTrade(Trade trade) {
        tradeRepository.addNewTrade(trade);
    }
}
