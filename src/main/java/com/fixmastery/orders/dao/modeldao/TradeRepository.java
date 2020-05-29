package com.fixmastery.orders.dao.modeldao;

import com.fixmastery.orders.dto.RawOrderData;
import com.fixmastery.orders.model.TradeCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TradeRepository {

    @Autowired
    OrderModelRepository orderRepo;

    Map<String, TradeCommand> tradeRepo = new HashMap<>();

    public void addNewTrade(TradeCommand tradeCommand) {
        tradeRepo.put(tradeCommand.getId(), tradeCommand);
    }

    public TradeCommand addNewTradeFromOrderData(RawOrderData data) {
        TradeCommand newTradeCommand = new TradeCommand(
            data.getInstanceId(),
            data.getDateTimeStamp(),
            orderRepo.getOrderById(data.getOrderId()),
            data.getInstrument(),
            data.getOrderStatus(),
            data.getSide(),
            data.getInitialQuantity()
        );

        addNewTrade(newTradeCommand);
        return newTradeCommand;
    }

    public Iterable<TradeCommand> getAll(){
        return tradeRepo.values();
    }

    public Iterable<String> getAllIds() {
        return tradeRepo.keySet();
    }

    public TradeCommand getTradeById(String id){
        return tradeRepo.get(id);
    }

    public TradeCommand updateAfterExecutionThroughOrderData(RawOrderData data) {
        TradeCommand tradeCommand = tradeRepo.get(data.getParentId());

        tradeCommand.setTradeStatusId(data.getOrderStatus());
        tradeCommand.setCompletedQuantity(data.getCompletedQuantity());
        tradeCommand.setPendingQuantity(data.getPendingQuantity());

        return tradeCommand;
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

    public Iterable<TradeCommand> getAllByOrderId(String orderId) {
        Collection<TradeCommand> allTradeCommands = tradeRepo.values();
        Iterable<TradeCommand> tradesOfOrder = allTradeCommands
            .stream()
            .filter(trade -> trade.getOrder().getId().equals(orderId))
            .collect(Collectors.toList());
        return tradesOfOrder;
    }
}
