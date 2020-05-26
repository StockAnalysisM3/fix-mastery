package com.fixmastery.orders.dao.strategies;

import com.fixmastery.orders.dao.modeldao.OrderModelRepository;
import com.fixmastery.orders.dao.modeldao.TradeRepository;
import com.fixmastery.orders.dto.OrderData;
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

    /**
     * The order strategy will only contain changes to Order instances
     *      trade changes, including creation of trades by using an order instances will be handled by the Trade strategy class
     */
    public void strategy(OrderData data) {
        this.message = "";
        if(data.getParentId() == null) {
            createNewOrder(data);
        }
        else if(
            tradeExistsWithinOrderInstance(data) &&
            data.getParentId().substring(0,2).equals("om") &&
            data.getCompletedQuantity() != null
        ) {
            updateOrder(data);
        }
    }

        private Order createNewOrder(OrderData data) {
            Order order = new Order(
                data.getInstanceId(),
                data.getClientId(),
                data.getInstrument(),
                data.getOrderStatus(),
                data.getOrderType(),
                data.getVenue(),
                data.getSide(),
                data.getInitialQuantity()
            );

            this.orderRepository.addNewOrder(order);

            // TODO: Abstract to its own messageClass
            this.message +=
                    "Order " + order.getId() + " has been created\n" +
                            order;

            return order;
        }

        private boolean tradeExistsWithinOrderInstance(OrderData data){
            return orderRepository.doesTradeIdExistInOrderInstance(
                data.getOrderId(), data.getInstanceId()
            );
        }

        private Order updateOrder(OrderData data) {
            Trade executedTrade = tradeRepository.getTradeById(data.getInstanceId());
            Order parentOrder = executedTrade.getOrder();
            executedTrade.updateOrder(data);

            if(data.getOrderStatus().equals("2")) {
                completeOrder(parentOrder);
            }

            //TODO: abstract to its own messageService class
            this.message +=
                    "Order " + parentOrder.getId() + " has been updated\n" +
                            parentOrder;

            return parentOrder;
        }

        private void completeOrder(Order order) {
            order.setFulfilled(true);
            this.message += "Order " + order.getId() + " has been fulfilled\n";
        }

    public String getMessage() {
        return message;
    }
}
