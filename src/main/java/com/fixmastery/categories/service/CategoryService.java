package com.fixmastery.categories.service;

import com.fixmastery.categories.dao.FixRepository;
import com.fixmastery.categories.dto.FixData;
import com.fixmastery.categories.model.MessageType;
import com.fixmastery.categories.model.OrderStatus;
import com.fixmastery.categories.model.OrderType;
import com.fixmastery.categories.model.Side;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class CategoryService {
    @Autowired
    private FixRepository repo;

    public Iterable<FixData> getAllAsFix() {
        return repo.findAll();
    }

    public Map<String, MessageType> messageTypeRepo(){
        Iterable<FixData> categoriesAsFix = repo.findAllByTag(35);
        Iterator<FixData> fixIterator = categoriesAsFix.iterator();
        Map<String, MessageType> repo = new HashMap<>();

        fixIterator.forEachRemaining(fix -> repo.put(
            fix.getValue(),
            new MessageType(fix.getValue(), fix.getDescr())
        ));

        return repo;
    };

    public Map<String, OrderStatus> orderStatusRepo(){
        Iterable<FixData> categoriesAsFix = repo.findAllByTag(39);
        Iterator<FixData> fixIterator = categoriesAsFix.iterator();
        Map<String, OrderStatus> repo = new HashMap<>();

        fixIterator.forEachRemaining(fix -> repo.put(
            fix.getValue(),
            new OrderStatus(fix.getValue(), fix.getDescr())
        ));
        return repo;
    };

    public Map<String, OrderType> orderTypeRepo(){
        Iterable<FixData> allOrderStatusesAsFix = repo.findAllByTag(40);
        Iterator<FixData> fixIterator = allOrderStatusesAsFix.iterator();
        Map<String, OrderType> repo = new HashMap<>();

        fixIterator.forEachRemaining(fix -> repo.put(
            fix.getValue(),
            new OrderType(fix.getValue(), fix.getDescr())
        ));
        return repo;
    };

    public Map<String, Side> sideRepo(){
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
