package com.fixmastery.orders.dao;

import com.fixmastery.orders.dao.modeldao.MessageRepository;
import com.google.common.collect.Iterators;
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

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private OrderDataRepository dataRepository;

    @BeforeEach
    void setUp() {
        adapter.adapt();
    }

    @Test
    void createdEqualInstancesOfMessagesAsOrderData() {
        long numOfMessages = Iterators.size(messageRepository.getAll().iterator());
        long numOfData = dataRepository.count();

        assertEquals(numOfData, numOfMessages, "Every data point should have a message");
    }

    @Test
    void createdAllSeedOrdersTest() {

    }

    @Test
    void createdAllSeedTradesTest() {

    }

}