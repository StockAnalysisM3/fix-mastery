package com.fixmastery.orders.dao.adapter;

import com.fixmastery.orders.dao.modeldao.OrderModelRepository;
import com.fixmastery.orders.dao.modeldao.TradeCommandRepository;
import com.fixmastery.orders.dto.RawOrderData;
import com.fixmastery.orders.misc.messenger.OrderMessenger;
import com.fixmastery.orders.model.Order;
import com.fixmastery.orders.model.TradeCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderStrategy {

    @Autowired
    OrderModelRepository orderRepository;

    @Autowired
    TradeCommandRepository tradeCommandRepository;

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
            this.message += OrderMessenger.orderIsCreatedMessage(newOrder);
            return newOrder;
        }

        private boolean tradeExistsWithinOrderInstance(RawOrderData data){
            return orderRepository.doesTradeIdExistInOrderInstance(
                data.getOrderId(), data.getInstanceId()
            );
        }

        private Order updateOrder(RawOrderData data) {
            TradeCommand executedTrade = tradeCommandRepository.getTradeCommandById(data.getInstanceId());
            Order parentOrder = orderRepository.getOrderParentFromTradeId(data.getInstanceId());
            executedTrade.updateParentOrder(data);
            this.message += OrderMessenger.orderIsUpdatedMessage(parentOrder);
            return parentOrder;
        }

        private void completeOrder(Order order) {
            order.fulfillOrder();
            this.message += OrderMessenger.orderHasBeenFulfilledMessage(order);
        }

    public String getMessage() {
        return message;
    }
}
