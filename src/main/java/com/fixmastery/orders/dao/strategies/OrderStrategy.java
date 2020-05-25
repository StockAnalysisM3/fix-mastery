package com.fixmastery.orders.dao.strategies;

import com.fixmastery.categories.dao.CategoryAdapter;
import com.fixmastery.orders.dao.modeldao.OrderModelRepository;
import com.fixmastery.orders.dto.OrderData;
import com.fixmastery.orders.model.Order;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderStrategy {

    @Autowired
    OrderModelRepository orderRepository;

    @Autowired
    CategoryAdapter categoryAdapter;

    private Order order;

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
//        else if(tradeExistsInOrder(data)) {
//            updateOrder(data);
//        }
    }

        private void createNewOrder(OrderData data) {
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
        }

//        private boolean tradeExistsInOrder(OrderData data){
//            return orderRepository.getOrderById(data.getOrderId()).getTradeList().containsKey(data.getInstanceId());
//        }

//        private void updateOrder(OrderData data) {
//            Order currentOrder =
//        }

        private void completeOrder(Order order) {
            order.setFulfilled(true);
        }

    public Order getOrder() {
        return order;
    }


}
