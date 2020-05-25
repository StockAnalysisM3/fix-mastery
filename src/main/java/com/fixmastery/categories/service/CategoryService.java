package com.fixmastery.categories.service;

import com.fixmastery.categories.dao.CategoryMaps;
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
    private CategoryMaps catMaps;

    public Iterable<FixData> getAllAsFix() {
        return fixRepo.findAll();
    }

    public long getFixSize() {
        return fixRepo.count();
    }

    public Iterable<MessageType> getAllMessageTypes() {
        return catMaps.messageTypeMap().values();
    }

    public Iterable<OrderStatus> getAllOrderStatuses() {
        return catMaps.orderStatusMap().values();
    }

    public Iterable<OrderType> getAllOrderTypes() {
        return catMaps.orderTypeMap().values();
    }

    public Iterable<Side> getAllSides() {
        return catMaps.sideMap().values();
    }

}
