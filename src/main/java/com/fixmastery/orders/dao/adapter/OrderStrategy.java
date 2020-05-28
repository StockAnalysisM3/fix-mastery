package com.fixmastery.orders.dao.adapter;

import com.fixmastery.orders.dao.modeldao.OrderModelRepository;
import com.fixmastery.orders.dao.modeldao.TradeRepository;
import com.fixmastery.orders.dto.RawOrderData;
import com.fixmastery.orders.model.Order;
import com.fixmastery.orders.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderStrategy {

    @Autowired
    OrderModelRepository orderRepository;

    @Autowired
    TradeRepository tradeRepository;

    private String message;

    public OrderStrategy() {}

    public void strategy(RawOrderData data) {
        this.message = "";
        if(data.getParentId() == null) {

            createNewOrderFromOrderData(data);

        }
        else if(
            tradeExistsWithinOrderInstance(data) &&
            data.getParentId().substring(0,2).equals("om") &&
            data.getCompletedQuantity() != null
        ) {
            Order updatedOrder = updateOrder(data);
            if(data.getOrderStatus().equals("2")) {
                completeOrder(updatedOrder);
            }
        }
    }

        private Order createNewOrderFromOrderData(RawOrderData data) {
            Order newOrder = orderRepository.addNewOrderFromOrderData(data);
            this.message += orderIsCreatedMessage(newOrder);
            return newOrder;
        }

            private String orderIsCreatedMessage(Order order) {
                return "Order " + order.getId() + " has been created\n" +
                        order;
            }

        private boolean tradeExistsWithinOrderInstance(RawOrderData data){
            return orderRepository.doesTradeIdExistInOrderInstance(
                data.getOrderId(), data.getInstanceId()
            );
        }

        private Order updateOrder(RawOrderData data) {
            Trade executedTrade = tradeRepository.getTradeById(data.getInstanceId());
            Order parentOrder = orderRepository.getOrderParentFromTradeId(data.getInstanceId());
            executedTrade.updateParentOrder(data);
            this.message += orderIsUpdatedMessage(parentOrder);
            return parentOrder;
        }

            private String orderIsUpdatedMessage(Order order) {
                return "Order " + order.getId() + " has been updated\n" +
                        order;
            }

        private void completeOrder(Order order) {
            order.setFulfilled(true);
            this.message += "\nOrder " + order.getId() + " has been fulfilled\n";
        }

    public String getMessage() {
        return message;
    }
}
