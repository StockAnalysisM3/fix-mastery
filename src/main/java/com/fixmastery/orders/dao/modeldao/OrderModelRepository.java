package com.fixmastery.orders.dao.modeldao;

import com.fixmastery.orders.dao.OrderDataRepository;
import com.fixmastery.orders.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderModelRepository {

    @Autowired
    private OrderDataRepository orderDataRepo;

    Map<String, Order> orderRepo = new HashMap<>();

    public Iterable<Order> getAll() {
        return orderRepo.values();
    }

    public Order getOrderById(String id) {
        return orderRepo.get(id);
    }

    public void addNewOrder(Order order){
        orderRepo.put(order.getId(), order);
    }

    public void setOrderRepo(Map<String, Order> orderRepo) {
        this.orderRepo = orderRepo;
    }
}


