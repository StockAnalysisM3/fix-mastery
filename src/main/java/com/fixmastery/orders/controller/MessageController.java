package com.fixmastery.orders.controller;

import com.fixmastery.errorshandlers.MapValidationErrorsService;
import com.fixmastery.orders.model.Message;
import com.fixmastery.orders.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private MapValidationErrorsService mapValidationErrorsService;

    @GetMapping("/size")
    public ResponseEntity<?> getMessagesSize() {
        long numOfMessages = messageService.getMessagesSize();
        return new ResponseEntity<Long>(numOfMessages, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllMessages() {
        Iterable<Message> allMessages = messageService.getAllMessages();
        return new ResponseEntity<Iterable<Message>>(allMessages, HttpStatus.OK);
    }

    @GetMapping("/ordermanager")
    public ResponseEntity<?> getOrderManagerMesssages() {
        Iterable<Message> orderManagerMessages = messageService.getAllMessagesFromOrderManager();
        return new ResponseEntity<Iterable<Message>>(orderManagerMessages, HttpStatus.OK);
    }

    @GetMapping("/tradeengine")
    public ResponseEntity<?> getTradeEngineMessages() {
        Iterable<Message> tradeEngineMessages = messageService.getAllMessagesFromTradingEngine();
        return new ResponseEntity<Iterable<Message>>(tradeEngineMessages, HttpStatus.OK);
    }

    @GetMapping("/idset")
    public ResponseEntity<?> getAllMessageIds() {
        Iterable<Long> allIds = messageService.getAllIds();
        return new ResponseEntity<Iterable<Long>>(allIds, HttpStatus.OK);
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<?> getMessageById(@PathVariable String id) {
        long longId = Long.parseLong(id);
        Optional<Message> message = messageService.getMessageById(longId);
        return new ResponseEntity<Optional<Message>>(message, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addOrUpdateMessage(@RequestBody Message message, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorsService.MapValidationErrorsService(result);

        if(errorMap != null) {
            return errorMap;
        }

        messageService.addOrUpdateMessage(message);

        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }
}
