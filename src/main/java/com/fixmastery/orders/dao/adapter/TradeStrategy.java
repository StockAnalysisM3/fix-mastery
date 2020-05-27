package com.fixmastery.orders.dao.adapter;

import com.fixmastery.orders.dao.modeldao.OrderModelRepository;
import com.fixmastery.orders.dao.modeldao.TradeRepository;
import com.fixmastery.orders.dto.RawOrderData;
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

    public void strategy(RawOrderData data) {
        this.message = "";
        if(
            data.getInstanceId().substring(0,2).equals("te") &&
            data.getParentId().substring(0,2).equals("om") &&
            data.getCompletedQuantity() == null
        ) {
            createTradeDirectlyFromOrder(data);
        } else if(
                data.getInstanceId().substring(0,2).equals("te") &&
                data.getParentId().substring(0,2).equals("te") &&
                data.getCompletedQuantity() != null
        ) {
            executeTrade(data);
        }
        // place one for updateParentTrade
    }

        private Trade createTradeDirectlyFromOrder(RawOrderData data) {
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

            this.message += tradeIsCreatedMessage(newTrade);

            return newTrade;
        }

            private String tradeIsCreatedMessage(Trade trade) {
                return "Trade " + trade.getId() + " has been created\n" +
                    trade;
            }

        private void executeTrade(RawOrderData data) {
            Trade executedTrade = tradeRepository.getTradeById(data.getParentId());
            executedTrade.executeTrade(data);

            this.message += tradeIsExecutedMessage(data);
        }

            private String tradeIsExecutedMessage(RawOrderData data) {
                return "Trade " + data.getParentId() + " has been executed\n" +
                    "Execution { Id: " + data.getInstanceId() + " Instrument: " + data.getInstrument() +" Quantity: " + data.getInitialQuantity() + " Price: " + data.getPrice() + "}";
            }

    public String getMessage() {
        return message;
    }
}
