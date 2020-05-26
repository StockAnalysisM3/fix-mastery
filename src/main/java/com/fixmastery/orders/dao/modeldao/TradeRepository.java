package com.fixmastery.orders.dao.modeldao;

import com.fixmastery.orders.model.Trade;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TradeRepository {
    Map<String, Trade> tradeRepo = new HashMap<>();

    public void addNewTrade(Trade trade) {
        tradeRepo.put(trade.getId(), trade);
    }

    public Iterable<Trade> getAll(){
        return tradeRepo.values();
    }

    public Iterable<Trade> getAllByOrderId(String orderId) {
        Collection<Trade> allTrades = tradeRepo.values();
        Iterable<Trade> tradesOfOrder = allTrades
            .stream()
            .filter(trade -> trade.getOrder().getId().equals(orderId))
            .collect(Collectors.toList());
        return tradesOfOrder;
    }

    public Trade getTradeById(String id){
        return tradeRepo.get(id);
    }

    public boolean doesTradeIdExistInOrderInstance(String orderId, String tradeId) {
        boolean found = false;

        found = tradeRepo.containsKey(tradeId);
        if(found) {
            found = doesOrderIDParamMatchWithTradeOrder(orderId, tradeId);
        }

        return found;
    }

        private boolean doesOrderIDParamMatchWithTradeOrder(String orderId, String tradeId) {
            return getTradeById(tradeId).getOrder().getId().equals(orderId);
        }
}
