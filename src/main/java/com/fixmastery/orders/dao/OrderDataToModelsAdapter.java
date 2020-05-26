package com.fixmastery.orders.dao;

import com.fixmastery.orders.dao.modeldao.MessageRepository;
import com.fixmastery.orders.dao.strategies.OrderStrategy;
import com.fixmastery.orders.dao.strategies.TradeStrategy;
import com.fixmastery.orders.dto.OrderData;
import com.fixmastery.orders.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class OrderDataToModelsAdapter {

    @Autowired
    OrderStrategy orderStrategy;

    @Autowired
    TradeStrategy tradeStrategy;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    private OrderDataRepository orderDataRepository;

    public void adapt() {
        Iterator<OrderData> allOrderData = orderDataRepository.findAll().iterator();
        allOrderData.forEachRemaining(data -> {
            adaptInstance(data);
        });
    }

    private void adaptInstance (OrderData data) {
        System.out.println("=====");
//        System.out.println(data);

        Message message
            = new Message(data.getId(), data.getDateTimeStamp(), data.getSystemId(), data.getMessage());

        orderStrategy.strategy(data);
        message.appendMessage(orderStrategy.getMessage());
        tradeStrategy.strategy(data);
        message.appendMessage(tradeStrategy.getMessage());

        System.out.println(message.getFullMessage());
        System.out.println("=====");
        messageRepository.addNewMessage(message);
    }


}
