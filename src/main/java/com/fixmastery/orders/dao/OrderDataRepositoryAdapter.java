package com.fixmastery.orders.dao;

import com.fixmastery.orders.dao.strategies.OrderStrategy;
import com.fixmastery.orders.dao.strategies.TradeStrategy;
import com.fixmastery.orders.dto.OrderData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class OrderDataRepositoryAdapter {

    @Autowired
    private OrderDataRepository orderDataRepository;

    public void adapt() {
        Iterator<OrderData> allOrderData = orderDataRepository.findAll().iterator();
        allOrderData.forEachRemaining(data -> adaptInstance(data));
    }

    private void adaptInstance (OrderData data) {
        String orderMessages = new OrderStrategy(data).getMessage();
        String tradeMessages = new TradeStrategy(data).getMessage();
    }
}
