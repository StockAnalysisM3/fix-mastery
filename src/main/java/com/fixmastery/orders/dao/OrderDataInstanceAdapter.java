package com.fixmastery.orders.dao;

import com.fixmastery.orders.dto.OrderData;
import com.fixmastery.orders.model.Message;
import com.fixmastery.orders.model.Order;
import com.fixmastery.orders.model.Trade;

public class OrderDataInstanceAdapter {
    private Order order;
    private Trade trade;
    private Message message;

//    public OrderDataInstanceAdapter(OrderData data) {
//        this.order = ;
//        this.trade = ;
//        this.message = ;
//    }

    private void adapt() {

    }

    public Order getOrder() {
        return order;
    }

    public Trade getTrade() {
        return trade;
    }

    public Message getMessage() {
        return message;
    }
}

