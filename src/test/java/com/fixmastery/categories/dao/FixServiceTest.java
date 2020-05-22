package com.fixmastery.categories.dao;

import com.fixmastery.categories.model.MessageType;
import com.fixmastery.categories.model.OrderStatus;
import com.fixmastery.categories.model.OrderType;
import com.fixmastery.categories.model.Side;
import com.fixmastery.categories.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class FixServiceTest {

    @Autowired
    private CategoryService service;

    @Test
    void orderStatusRepoTest() {
        Map<String, OrderStatus> orderStatuses= service.orderStatusRepo();
        int numberOfOrderStatuses = orderStatuses.size();
        assertEquals(14, numberOfOrderStatuses, "There should be 14 order statuses");
    }

    @Test
    void messageTypeRepoTest() {
        Map<String, MessageType> messageStatuses = service.messageTypeRepo();
        int numberOfMessageStatuses = messageStatuses.size();
        assertEquals(3, numberOfMessageStatuses, "There should be three message statuses");
    }

    @Test
    void sideRepoTest() {
        Map<String, Side> sideTypes = service.sideRepo();
        int numberOfSideTypes = sideTypes.size();
        assertEquals(16, numberOfSideTypes, "There should be 16 side types");
    }

    @Test
    void orderTypeRepoTest() {
        Map<String, OrderType> orderTypes = service.orderTypeRepo();
        int numberOfOrderTypes = orderTypes.size();
        assertEquals(19, numberOfOrderTypes, "There should be 19 order types");
    }
}