package com.fixmastery.orders.model;

import com.fixmastery.orders.dao.RawOrderDataRepository;
import com.fixmastery.orders.dto.RawOrderData;
import com.google.common.collect.Iterators;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class RawOrderDataTest {

    @Autowired
    private RawOrderDataRepository rawOrderDataRepository;

    @BeforeEach
    void setUp() {
        rawOrderDataRepository.findAll().iterator().forEachRemaining(order -> System.out.println(order));
    }

    @Test
    void loadAllMessagesTest() {
        Iterator<RawOrderData> allOrders = rawOrderDataRepository.findAll().iterator();
        int numOfOrders = Iterators.size(allOrders);

        assertEquals(75, numOfOrders, "There should be 75 initial orders");
    }

    @Test
    void loadAllTradesTest() {

    }

    @Test
    void loadAllOrdersTest() {

    }
}