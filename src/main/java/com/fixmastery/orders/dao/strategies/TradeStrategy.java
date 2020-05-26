package com.fixmastery.orders.dao.strategies;

import com.fixmastery.orders.dao.modeldao.OrderModelRepository;
import com.fixmastery.orders.dao.modeldao.TradeRepository;
import com.fixmastery.orders.dto.OrderData;
import com.fixmastery.orders.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TradeStrategy {

    @Autowired
    OrderModelRepository orderRepository;

    @Autowired
    TradeRepository tradeRepository;

    private String message = "";

    public TradeStrategy() {}

    public void strategy(OrderData data) {
        this.message = "";
        if(
            data.getInstanceId().substring(0,2).equals("te") &&
            data.getParentId().substring(0,2).equals("om") &&
            data.getCompletedQuantity() == null
        ) {
            createTrade(data);
        } else if(
                data.getInstanceId().substring(0,2).equals("te") &&
                data.getParentId().substring(0,2).equals("te") &&
                data.getCompletedQuantity() != null
        ) {
            executeTrade(data);
        }
    }

        private Trade createTrade(OrderData data) {
            Trade newTrade = new Trade(
                data.getInstanceId(),
                data.getDateTimeStamp(),
                orderRepository.getOrderById(data.getOrderId()),
                data.getInstrument(),
                data.getOrderStatus(),
                data.getSide(),
                data.getInitialQuantity()
            );

            tradeRepository.addNewTrade(newTrade);

            // TODO: Abstract to its own messageClass
            this.message +=
                    "Trade " + newTrade.getId() + " has been created\n" +
                            newTrade;

            return newTrade;
        }

        private void executeTrade(OrderData data) {
            Trade executedTrade = tradeRepository.getTradeById(data.getParentId());
            executedTrade.executeTrade(data);

            // TODO: Abstract to its own messageClass
            this.message +=
                    "Trade " + executedTrade.getId() + " has been executed\n" +
                            executedTrade;
        }

    public String getMessage() {
        return message;
    }
}
