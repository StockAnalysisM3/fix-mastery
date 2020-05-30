package com.fixmastery.orders.dao.adapter;

import com.fixmastery.orders.dao.RawOrderDataRepository;
import com.fixmastery.orders.dao.modeldao.MessageRepository;
import com.fixmastery.orders.dto.RawOrderData;
import com.fixmastery.orders.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class DataToModelsAdapter {

    @Autowired
    private OrderStrategy orderStrategy;

    @Autowired
    private TradeStrategy tradeStrategy;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private RawOrderDataRepository rawOrderDataRepository;

//    // TODO: Autowire ExecutionStrategy
//    @Autowired
//    private ExecutionStrategy executionStrategy;

    public void adapt() {
        Iterator<RawOrderData> allOrderData = rawOrderDataRepository.findAll().iterator();
        allOrderData.forEachRemaining(data -> adaptInstance(data));
    }

    private void adaptInstance (RawOrderData data) {
        System.out.println("===============================================");
        System.out.println(data);
        Message message
            = new Message(
                data.getId(),
                data.getDateTimeStamp(),
                data.getSystemId(),
                data.getMessageType(),
                data.getMessage()
            );

        orderStrategy.strategy(data);
        message.appendMessage(orderStrategy.getMessage());

        tradeStrategy.strategy(data);
        message.appendMessage(tradeStrategy.getMessage());

        //TODO: place executionStrategy here

        System.out.println(message.getFullMessage());

        messageRepository.addNewMessage(message);
    }

}
