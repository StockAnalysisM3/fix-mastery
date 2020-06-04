package com.fixmastery.orders.controller;

import com.fixmastery.errorshandlers.MapValidationErrorsService;
import com.fixmastery.orders.model.TradeCommand;
import com.fixmastery.orders.model.TradeExecution;
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

    // Command

    @GetMapping("/size")
    public ResponseEntity<?> getTradeCommandsSize() {
        long numOfTrades = tradeService.getTradeCommandsSize();
        return new ResponseEntity<Long>(numOfTrades, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTradeCommands() {
        Iterable<TradeCommand> allTrades = tradeService.getAllTradeCommands();
        return new ResponseEntity<Iterable<TradeCommand>>(allTrades, HttpStatus.OK);
    }

    @GetMapping("/idset")
    public ResponseEntity<?> getAllTradeCommandIds() {
        Iterable<String> allIds = tradeService.getAllTradeCommandIds();
        return new ResponseEntity<Iterable<String>>(allIds, HttpStatus.OK);
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<?> getTradeCommandById(@PathVariable String id) {
        Optional<TradeCommand> trade = tradeService.getTradeCommandById(id);
        return new ResponseEntity<Optional<TradeCommand>>(trade, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addOrUpdateTradeCommand(@RequestBody TradeCommand tradeCommand, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorsService.MapValidationErrorsService(result);

        if(errorMap != null) {
            return errorMap;
        }

        tradeService.addOrUpdateTradeCommand(tradeCommand);

        return new ResponseEntity<TradeCommand>(tradeCommand, HttpStatus.OK);
    }

    // Execution

    @GetMapping("/byid/{id}/execs")
    public ResponseEntity<?> getTradeExecutionsFromCommandId(@PathVariable String id) {
        Optional<TradeCommand> tradeCommand = tradeService.getTradeCommandById(id);
        Iterable<TradeExecution> tradeExecutionsInCommand
            = tradeService.getTradeExecutionsFromCommand(tradeCommand.get());
        return new ResponseEntity<Iterable<TradeExecution>>(tradeExecutionsInCommand, HttpStatus.OK);
    }

    @GetMapping("/exec/size")
    public ResponseEntity<?> getTradeExecutionsSize() {
        long numOfTrades = tradeService.getTradeExecutionsSize();
        return new ResponseEntity<Long>(numOfTrades, HttpStatus.OK);
    }

    @GetMapping("/exec/all")
    public ResponseEntity<?> getAllTradeExecutions() {
        Iterable<TradeExecution> allTrades = tradeService.getAllTradeExecutions();
        return new ResponseEntity<Iterable<TradeExecution>>(allTrades, HttpStatus.OK);
    }

    @GetMapping("/exec/byid/{id}")
    public ResponseEntity<?> getTradeExecutionById(@PathVariable String id) {
        Optional<TradeExecution> trade = tradeService.getTradeExecutionById(id);
        return new ResponseEntity<Optional<TradeExecution>>(trade, HttpStatus.OK);
    }



}
