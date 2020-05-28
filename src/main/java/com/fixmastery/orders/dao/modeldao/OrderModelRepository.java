package com.fixmastery.orders.dao.modeldao;

import com.fixmastery.orders.dto.RawOrderData;
import com.fixmastery.orders.model.Order;
import com.fixmastery.orders.model.TradeCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrderModelRepository {

    @Autowired
    TradeRepository tradeRepo;

    Map<String, Order> orderRepo = new HashMap<>();

    public void addNewOrder(Order order){
        orderRepo.put(order.getId(), order);
    }

    public Order addNewOrderFromOrderData(RawOrderData data) {
        Order newOrder = new Order(
                data.getInstanceId(),
                data.getClientId(),
                data.getOrderStatus(),
                data.getVenue()
        );

        addNewOrder(newOrder);
        return newOrder;
    }

    public Iterable<Order> getAll() {
        return orderRepo.values();
    }

    public Iterable<String> getAllIds() {
        return orderRepo.keySet();
    }

    public Order getOrderById(String id) {
        return orderRepo.get(id);
    }

    public Order getOrderParentFromTradeId(String tradeId) {
        TradeCommand tradeCommand = tradeRepo.getTradeById(tradeId);
        return tradeCommand.getOrder();
    }

    public boolean doesTradeIdExistInOrderInstance(String orderId, String tradeId) {
        return tradeRepo.doesTradeIdExistInOrderInstance(orderId, tradeId);
    }


}


