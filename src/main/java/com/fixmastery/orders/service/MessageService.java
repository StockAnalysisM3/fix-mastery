package com.fixmastery.orders.service;

import com.fixmastery.orders.dao.modeldao.MessageRepository;
import com.fixmastery.orders.model.Message;
import com.google.common.collect.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.management.MemoryUsage;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public long getMessagesSize() {
        return Iterators.size(messageRepository.getAll().iterator());
    }

    public Iterable<Message> getAllMessages() {
        return messageRepository.getAll();
    }

    public Iterable<Long> getAllIds() {
        return messageRepository.getAllIds();
    }

    public Iterable<Message> getAllMessagesFromOrderManager() {
        return messageRepository.getAllBySystem("OrderManager");
    }

    public Iterable<Message> getAllMessagesFromTradingEngine() {
        return messageRepository.getAllBySystem("TradingEngine");
    }

    public Iterable<Message> getAllMessagesSortedByDate() {
        return messageRepository.getAllMessagesSortedByDate();
    }

    public Optional<Message> getMessageById(Long id) {
        return Optional.ofNullable(messageRepository.getMessageById(id));
    }

    public void addOrUpdateMessage(Message message) {
        messageRepository.addNewMessage(message);
    }
}
