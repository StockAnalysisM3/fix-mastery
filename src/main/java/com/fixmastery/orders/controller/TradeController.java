package com.fixmastery.orders.controller;

import com.fixmastery.errorshandlers.MapValidationErrorsService;
import com.fixmastery.orders.model.TradeCommand;
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
        Iterable<TradeCommand> allTrades = tradeService.getAllTrades();
        return new ResponseEntity<Iterable<TradeCommand>>(allTrades, HttpStatus.OK);
    }

    @GetMapping("/idset")
    public ResponseEntity<?> getAllTradeIds() {
        Iterable<String> allIds = tradeService.getAllTradeIds();
        return new ResponseEntity<Iterable<String>>(allIds, HttpStatus.OK);
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<?> getTradeById(@PathVariable String id) {
        Optional<TradeCommand> trade = tradeService.getTradeById(id);
        return new ResponseEntity<Optional<TradeCommand>>(trade, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addOrUpdateTrade(@RequestBody TradeCommand tradeCommand, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorsService.MapValidationErrorsService(result);

        if(errorMap != null) {
            return errorMap;
        }

        tradeService.addOrUpdateTrade(tradeCommand);

        return new ResponseEntity<TradeCommand>(tradeCommand, HttpStatus.OK);
    }

    // Exec
    // get 1
    // get all
    // get by command

}
