package com.fixmastery.orders.dao.modeldao;

import com.fixmastery.orders.model.Message;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MessageRepository {
    Map<Long, Message> messageRepo = new HashMap<>();

    public void addNewMessage(Message message) {
        messageRepo.put(message.getId(), message);
    }

    public Iterable<Message> getAll() {
        return messageRepo.values();
    }

    public Iterable<Message> getAllBySystem(String system) {
        Collection<Message> allMessages = messageRepo.values();
        Iterable<Message> messagesOfSystem = allMessages
            .stream()
            .filter(message -> message.getSystem().equals(system))
            .collect(Collectors.toList());
        return messagesOfSystem;
    }

    public Iterable<Message> getAllMessagesSortedByDate() {
        Collection<Message> allMessages = messageRepo.values();
        Iterable<Message> sortedMessages = allMessages
            .stream()
            .sorted(Comparator.comparing(Message::getDateTimeStamp))
            .collect(Collectors.toList());
        return sortedMessages;
    }

    public Message getMessageById(Long id) {
        return messageRepo.get(id);
    }


}
