package com.fixmastery.categories.service;

import com.fixmastery.categories.dao.CategoryRepository;
import com.fixmastery.categories.dao.FixRepository;
import com.fixmastery.categories.dto.FixData;
import com.fixmastery.categories.model.MessageType;
import com.fixmastery.categories.model.OrderStatus;
import com.fixmastery.categories.model.OrderType;
import com.fixmastery.categories.model.Side;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private FixRepository fixRepo;

    @Autowired
    private CategoryRepository catRepo;

    public Iterable<FixData> getAllAsFix() {
        return fixRepo.findAll();
    }

    public long getFixSize() {
        return fixRepo.count();
    }

    public Iterable<MessageType> getAllMessageTypes() {
        return catRepo.messageTypeRepo().values();
    }

    public Iterable<OrderStatus> getAllOrderStatuses() {
        return catRepo.orderStatusRepo().values();
    }

    public Iterable<OrderType> getAllOrderTypes() {
        return catRepo.orderTypeRepo().values();
    }

    public Iterable<Side> getAllSides() {
        return catRepo.sideRepo().values();
    }

}
