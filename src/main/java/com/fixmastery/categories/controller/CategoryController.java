package com.fixmastery.categories.controller;

import com.fixmastery.categories.dao.FixRepository;
import com.fixmastery.categories.dto.Fix;
import com.fixmastery.categories.model.OrderStatus;
import com.fixmastery.categories.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/orderstatus/size")
    public ResponseEntity<?> getOrderStatusesSize() {
        long allOrderStatuses = categoryService.orderStatusRepo().values().size();
        return new ResponseEntity<Long>(allOrderStatuses, HttpStatus.OK);
    }


}
