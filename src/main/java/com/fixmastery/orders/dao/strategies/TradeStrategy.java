package com.fixmastery.orders.dao.strategies;

import com.fixmastery.categories.dao.CategoryAdapter;
import com.fixmastery.orders.dao.modeldao.OrderModelRepository;
import com.fixmastery.orders.dao.modeldao.TradeRepository;
import com.fixmastery.orders.dto.OrderData;
import com.fixmastery.orders.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;

public class TradeStrategy {

    @Autowired
    OrderModelRepository orderRepository;

    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    CategoryAdapter categoryAdapter;

    private String message;

    public TradeStrategy(OrderData data) {
        strategy(data);
    }

    private void strategy(OrderData data) {
        if(
            data.getInstanceId().substring(0,2).equals("te") &&
            data.getCompletedQuantity() == null
        ) {
            createTrade(data);
        } else if(
                data.getInstanceId().substring(0,2).equals("te") &&
                data.getParentId().substring(0,2).equals("te")
        ) {
            executeTrade();
        }
    }

        private Trade createTrade(OrderData data) {
            Trade newTrade = new Trade(
                data.getInstanceId(),
                data.getDateTimeStamp(),
                orderRepository.getOrderById(data.getOrderId()),
                data.getInstrument(),
                categoryAdapter.orderStatusMap().get(data.getOrderStatus()),
                categoryAdapter.sideMap().get(data.getSide()),
                data.getInitialQuantity()
            );

            tradeRepository.addNewTrade(newTrade);

            // TODO: Abstract to its own messageClass
            this.message +=
                    "Trade " + newTrade.getId() + " has been created\n" +
                            newTrade;

            return newTrade;
        }

        private void executeTrade() {
            System.out.println("Create Trade Instance");
        }

    public String getMessage() {
        return message;
    }
}
