package com.fixmastery.orders.service;

import com.fixmastery.orders.dao.modeldao.OrderModelRepository;
import com.fixmastery.orders.model.Order;
import com.google.common.collect.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderModelRepository orderRepo;

    public long getSize() {
        return Iterators.size(orderRepo.getAll().iterator());
    }

    public Optional<Order> getOrderById(String id) {
        return Optional.ofNullable(orderRepo.getOrderById(id));
    }

    public Iterable<Order> getAllOrders() {
        return orderRepo.getAll();
    }

    public Iterable<String> getAllOrderIds() {
        return orderRepo.getAllIds();
    }

    public void addOrUpdateNewOrder(Order order) {
        orderRepo.addNewOrder(order);
    }

}
