package com.fixmastery.orders.model;

import com.fixmastery.orders.dao.OrderRepository;
import com.google.common.collect.Iterators;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class OrderTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void successfulDataAccessTest() {
        Iterator<Order> allOrders = orderRepository.findAll().iterator();
        int numOfOrders = Iterators.size(allOrders);

        assertEquals(75, numOfOrders, "There should be 75 initial orders");
    }

//    @Test
//    void getDatetimestamp() {
//
//    }

//    @Test
//    void setDatetimestamp() {
//    }
}