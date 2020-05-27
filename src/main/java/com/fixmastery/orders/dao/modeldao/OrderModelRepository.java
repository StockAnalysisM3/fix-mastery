package com.fixmastery.orders.dao.modeldao;

import com.fixmastery.orders.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrderModelRepository {

    @Autowired
    TradeRepository tradeRepo;

    Map<String, Order> orderRepo = new HashMap<>();

    public Iterable<Order> getAll() {
        return orderRepo.values();
    }

    public Iterable<String> getAllIds() {
        return orderRepo.keySet();
    }

    public Order getOrderById(String id) {
        return orderRepo.get(id);
    }

    public void addNewOrder(Order order){
        orderRepo.put(order.getId(), order);
    }

    public boolean doesTradeIdExistInOrderInstance(String orderId, String tradeId) {
        return tradeRepo.doesTradeIdExistInOrderInstance(orderId, tradeId);
    }


}


