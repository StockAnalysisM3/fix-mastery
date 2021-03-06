package com.fixmastery.categories.dao;

import com.fixmastery.categories.dto.RawFixData;
import com.fixmastery.categories.model.MessageType;
import com.fixmastery.categories.model.OrderStatus;
import com.fixmastery.categories.model.OrderType;
import com.fixmastery.categories.model.Side;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component
public class CategoryAdapter {
    @Autowired
    private RawFixDataRepository repo;

    public Map<String, MessageType> messageTypeMap(){
        Iterable<RawFixData> categoriesAsFix = repo.findAllByTag(35);
        Iterator<RawFixData> fixIterator = categoriesAsFix.iterator();
        Map<String, MessageType> repo = new HashMap<>();

        fixIterator.forEachRemaining(fix -> repo.put(
            fix.getValue(),
            new MessageType(fix.getValue(), fix.getDescr())
        ));

        return repo;
    };

    public Map<String, OrderStatus> orderStatusMap(){
        Iterable<RawFixData> categoriesAsFix = repo.findAllByTag(39);
        Iterator<RawFixData> fixIterator = categoriesAsFix.iterator();
        Map<String, OrderStatus> repo = new HashMap<>();

        fixIterator.forEachRemaining(fix -> repo.put(
            fix.getValue(),
            new OrderStatus(fix.getValue(), fix.getDescr())
        ));
        return repo;
    };

    public Map<String, OrderType> orderTypeMap(){
        Iterable<RawFixData> allOrderStatusesAsFix = repo.findAllByTag(40);
        Iterator<RawFixData> fixIterator = allOrderStatusesAsFix.iterator();
        Map<String, OrderType> repo = new HashMap<>();

        fixIterator.forEachRemaining(fix -> repo.put(
            fix.getValue(),
            new OrderType(fix.getValue(), fix.getDescr())
        ));
        return repo;
    };

    public Map<String, Side> sideMap(){
        Iterable<RawFixData> categoriesAsFix = repo.findAllByTag(54);
        Iterator<RawFixData> fixIterator = categoriesAsFix.iterator();
        Map<String, Side> repo = new HashMap<>();

        fixIterator.forEachRemaining(fix -> repo.put(
            fix.getValue(),
            new Side(fix.getValue(), fix.getDescr())
        ));
        return repo;
    };
}
