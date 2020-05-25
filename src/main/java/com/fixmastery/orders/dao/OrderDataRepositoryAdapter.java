package com.fixmastery.orders.dao;

import com.fixmastery.orders.dto.OrderData;
import com.fixmastery.orders.model.Message;
import com.fixmastery.orders.model.Order;
import com.fixmastery.orders.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;

@Component
public class OrderDataRepositoryAdapter {
    @Autowired
    private OrderDataRepository orderDataRepository;

    private static OrderDataInstanceAdapter adapter;

    private Map<String, Order> orderRepo;
    private Map<String, Trade> tradeRepo;
    private Map<String, Message> messageRepo;

    private void adapt() {
        Iterator<OrderData> allOrderData = orderDataRepository.findAll().iterator();
    }

//    private Map<Integer, Map<String, ?>> getEntitiesPerOrderData(OrderData orderData) {
//
//    }

    private void setOrderRepo(Map<String, Order> orderRepo) {
        this.orderRepo = orderRepo;
    }

    private void setTradeRepo(Map<String, Trade> tradeRepo) {
        this.tradeRepo = tradeRepo;
    }

    private void setMessageRepo(Map<String, Message> messageRepo) {
        this.messageRepo = messageRepo;
    }

    public Map<String, Order> getOrderRepo() {
        return orderRepo;
    }

    public Map<String, Trade> getTradeRepo() {
        return tradeRepo;
    }

    public Map<String, Message> getMessageRepo() {
        return messageRepo;
    }
}
