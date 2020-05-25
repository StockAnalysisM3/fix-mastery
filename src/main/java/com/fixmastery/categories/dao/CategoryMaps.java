package com.fixmastery.categories.dao;

import com.fixmastery.categories.dto.FixData;
import com.fixmastery.categories.model.MessageType;
import com.fixmastery.categories.model.OrderStatus;
import com.fixmastery.categories.model.OrderType;
import com.fixmastery.categories.model.Side;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Repository
public class CategoryMaps {
    @Autowired
    private FixRepository repo;

    public Map<String, MessageType> messageTypeMap(){
        Iterable<FixData> categoriesAsFix = repo.findAllByTag(35);
        Iterator<FixData> fixIterator = categoriesAsFix.iterator();
        Map<String, MessageType> repo = new HashMap<>();

        fixIterator.forEachRemaining(fix -> repo.put(
            fix.getValue(),
            new MessageType(fix.getValue(), fix.getDescr())
        ));

        return repo;
    };

    public Map<String, OrderStatus> orderStatusMap(){
        Iterable<FixData> categoriesAsFix = repo.findAllByTag(39);
        Iterator<FixData> fixIterator = categoriesAsFix.iterator();
        Map<String, OrderStatus> repo = new HashMap<>();

        fixIterator.forEachRemaining(fix -> repo.put(
            fix.getValue(),
            new OrderStatus(fix.getValue(), fix.getDescr())
        ));
        return repo;
    };

    public Map<String, OrderType> orderTypeMap(){
        Iterable<FixData> allOrderStatusesAsFix = repo.findAllByTag(40);
        Iterator<FixData> fixIterator = allOrderStatusesAsFix.iterator();
        Map<String, OrderType> repo = new HashMap<>();

        fixIterator.forEachRemaining(fix -> repo.put(
            fix.getValue(),
            new OrderType(fix.getValue(), fix.getDescr())
        ));
        return repo;
    };

    public Map<String, Side> sideMap(){
        Iterable<FixData> categoriesAsFix = repo.findAllByTag(54);
        Iterator<FixData> fixIterator = categoriesAsFix.iterator();
        Map<String, Side> repo = new HashMap<>();

        fixIterator.forEachRemaining(fix -> repo.put(
            fix.getValue(),
            new Side(fix.getValue(), fix.getDescr())
        ));
        return repo;
    };
}
