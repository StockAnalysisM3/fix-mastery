package com.fixmastery.orders.dao;

import com.fixmastery.orders.dao.modeldao.OrderModelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class OrderDataToModelsAdapterTest {

    @Autowired
    private OrderDataToModelsAdapter adapter;

    @BeforeEach
    void setUp() {
        adapter.adapt();
    }

    @Test
    void adaptTest() {
        System.out.println("running initial test");
    }

    @Test
    void createdAllSeedOrdersTest() {

    }

    @Test
    void createdAllSeedTradesTest() {

    }

}