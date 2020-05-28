package com.fixmastery.categories.controller;

import com.fixmastery.categories.dto.RawFixData;
import com.fixmastery.categories.model.MessageType;
import com.fixmastery.categories.model.OrderStatus;
import com.fixmastery.categories.model.OrderType;
import com.fixmastery.categories.model.Side;
import com.fixmastery.categories.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories/")
public class CategoryController {

    @Autowired
    private CategoryService catService;


    @GetMapping("/size")
    public ResponseEntity<?> getOrderStatusesSize() {
        long numOfCategories = catService.getFixSize();
        return new ResponseEntity<Long>(numOfCategories, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllInFix() {
        Iterable<RawFixData> allFix = catService.getAllAsFix();
        return new ResponseEntity<Iterable<RawFixData>>(allFix, HttpStatus.OK);
    }

    @GetMapping("/orderstatus")
    public ResponseEntity<?> getOrderStatuses() {
        Iterable<OrderStatus> allOrderStatuses = catService.getAllOrderStatuses();
        return new ResponseEntity<Iterable<OrderStatus>>(allOrderStatuses, HttpStatus.OK);
    }

    @GetMapping("/messagetype")
    public ResponseEntity<?> getAllMessageTypes() {
        Iterable<MessageType> allMessageTypes = catService.getAllMessageTypes();
        return new ResponseEntity<Iterable<MessageType>>(allMessageTypes, HttpStatus.OK);
    }

    @GetMapping("/ordertype")
    public ResponseEntity<?> getOrderTypes(){
        Iterable<OrderType> allOrderTypes = catService.getAllOrderTypes();
        return new ResponseEntity<Iterable<OrderType>>(allOrderTypes, HttpStatus.OK);
    }

    @GetMapping("/sides")
    public ResponseEntity<?> allSides() {
        Iterable<Side> allSides = catService.getAllSides();
        return new ResponseEntity<Iterable<Side>>(allSides, HttpStatus.OK);
    }



}
