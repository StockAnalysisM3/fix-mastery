package com.fixmastery.categories.controller;

import com.fixmastery.categories.dto.Fix;
import com.fixmastery.categories.model.MessageType;
import com.fixmastery.categories.model.OrderStatus;
import com.fixmastery.categories.model.OrderType;
import com.fixmastery.categories.model.Side;
import com.fixmastery.categories.service.CategoryService;
import com.google.common.collect.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("/api/categories/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<?> getAllInFix() {
        Iterable<Fix> allFix = categoryService.getAllAsFix();
        return new ResponseEntity<Iterable<Fix>>(allFix, HttpStatus.OK);
    }

    @GetMapping("/orderstatus")
    public ResponseEntity<?> getOrderStatuses() {
        Iterator<OrderStatus> allOrderStatuses = categoryService.orderStatusRepo().values().iterator();
        return new ResponseEntity<Iterator<OrderStatus>>(allOrderStatuses, HttpStatus.OK);
    }

    @GetMapping("/size")
    public ResponseEntity<?> getOrderStatusesSize() {
        Iterator<Fix> allFix = categoryService.getAllAsFix().iterator();
        long numOfCategories = Iterators.size(allFix);
        return new ResponseEntity<Long>(numOfCategories, HttpStatus.OK);
    }

    @GetMapping("/messagetype")
    public ResponseEntity<?> getAllMessageTypes() {
        Iterator<MessageType> allMessageTypes = categoryService.messageTypeRepo().values().iterator();
        return new ResponseEntity<Iterator<MessageType>>(allMessageTypes, HttpStatus.OK);
    }

    @GetMapping("/ordertype")
    public ResponseEntity<?> getOrderTypes(){
        Iterator<OrderType> allOrderTypes = categoryService.orderTypeRepo().values().iterator();
        return new ResponseEntity<Iterator<OrderType>>(allOrderTypes, HttpStatus.OK);
    }

    @GetMapping("/sides")
    public ResponseEntity<?> allSides() {
        Iterator<Side> allSides = categoryService.sideRepo().values().iterator();
        return new ResponseEntity<Iterator<Side>>(allSides, HttpStatus.OK);
    }



}
