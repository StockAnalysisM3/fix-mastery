package com.fixmastery.orders.controller;

import com.fixmastery.errorshandlers.MapValidationErrorsService;
import com.fixmastery.orders.model.Trade;
import com.fixmastery.orders.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/trades/")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @Autowired
    private MapValidationErrorsService mapValidationErrorsService;

    @GetMapping("/size")
    public ResponseEntity<?> getTradesSize() {
        long numOfTrades = tradeService.getTradesSize();
        return new ResponseEntity<Long>(numOfTrades, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTrades() {
        Iterable<Trade> allTrades = tradeService.getAllTrades();
        return new ResponseEntity<Iterable<Trade>>(allTrades, HttpStatus.OK);
    }

    @GetMapping("/idSet")
    public ResponseEntity<?> getAllOrderIds() {
        Iterable<String> allIds = tradeService.getAllTradeIds();
        return new ResponseEntity<Iterable<String>>(allIds, HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable String id) {
        Optional<Trade> trade = tradeService.getTradeById(id);
        return new ResponseEntity<Optional<Trade>>(trade, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addOrUpdateTrade(@RequestBody Trade trade, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorsService.MapValidationErrorsService(result);

        if(errorMap != null) {
            return errorMap;
        }

        tradeService.addOrUpdateTrade(trade);

        return new ResponseEntity<Trade>(trade, HttpStatus.OK);
    }

}
