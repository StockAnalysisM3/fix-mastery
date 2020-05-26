package com.fixmastery.orders.dao.strategies;

import com.fixmastery.categories.dao.CategoryAdapter;
import com.fixmastery.orders.dao.modeldao.OrderModelRepository;
import com.fixmastery.orders.dao.modeldao.TradeRepository;
import com.fixmastery.orders.dto.OrderData;
import com.fixmastery.orders.model.Order;
import com.fixmastery.orders.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderStrategy {

    @Autowired
    OrderModelRepository orderRepository;

    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    CategoryAdapter categoryAdapter;

    private String message;

    public OrderStrategy(OrderData data) {
        strategy(data);
    }

    /**
     * The order strategy will only contain changes to Order instances
     *      trade changes, including creation of trades by using an order instances will be handled by the Trade strategy class
     */
    private void strategy(OrderData data) {
        if(data.getParentId() == null) {
            createNewOrder(data);
        }
        else if(tradeExistsWithinOrderInstance(data)) {
            updateOrder(data);
        }
        this.message += data.getMessage();
    }

        private Order createNewOrder(OrderData data) {
            Order order = new Order(
                data.getOrderId(),
                data.getClientId(),
                data.getInstrument(),
                categoryAdapter.orderStatusMap().get(data.getOrderStatus()),
                categoryAdapter.orderTypeMap().get(data.getOrderType()),
                data.getVenue(),
                categoryAdapter.sideMap().get(data.getSide()),
                data.getInitialQuantity(),
                data.getCompletedQuantity(),
                data.getPendingQuantity(),
                data.getPrice()
            );

            orderRepository.addNewOrder(order);

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
            executedTrade.updateOrder(data.getPrice());

            if(data.getOrderStatus().equals(1)) {
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
        }

    public String getMessage() {
        return message;
    }
}
