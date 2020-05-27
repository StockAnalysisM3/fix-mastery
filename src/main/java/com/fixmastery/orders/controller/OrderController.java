package com.fixmastery.orders.controller;

import com.fixmastery.errorshandlers.MapValidationErrorsService;
import com.fixmastery.orders.model.Order;
import com.fixmastery.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/orders/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private MapValidationErrorsService mapValidationErrorsService;

    @GetMapping("/size")
    public ResponseEntity<?> getOrdersSize() {
        long numOfOrders = orderService.getSize();
        return new ResponseEntity<Long>(numOfOrders, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllOrders() {
        Iterable<Order> allOrders = orderService.getAllOrders();
        return new ResponseEntity<Iterable<Order>>(allOrders, HttpStatus.OK);
    }

    @GetMapping("/idset")
    public ResponseEntity<?> getAllOrderIds() {
        Iterable<String> allIds = orderService.getAllOrderIds();
        return new ResponseEntity<Iterable<String>>(allIds, HttpStatus.OK);
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable String id) {
        Optional<Order> order = orderService.getOrderById(id);
        return new ResponseEntity<Optional<Order>>(order, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addOrUpdateOrder(@RequestBody Order order, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorsService.MapValidationErrorsService(result);

        if(errorMap != null) {
            return errorMap;
        }

        orderService.addOrUpdateNewOrder(order);

        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }


}
