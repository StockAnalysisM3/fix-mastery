package com.fixmastery.orders.dao.adapter;

import com.fixmastery.orders.dao.modeldao.TradeCommandRepository;
import com.fixmastery.orders.dao.modeldao.TradeExecutionRepository;
import com.fixmastery.orders.dto.RawOrderData;
import com.fixmastery.orders.misc.messenger.TradeMessenger;
import com.fixmastery.orders.model.TradeCommand;
import com.fixmastery.orders.model.TradeExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// The TradeStrategy will contain cases for the two Trade classes
@Component
public class TradeStrategy {

    @Autowired
    TradeCommandRepository tradeCommandRepository;

    @Autowired
    TradeExecutionRepository tradeExecutionRepository;

    private String message = "";

    public TradeStrategy() {}

    public void strategy(RawOrderData data) {
        this.message = "";

        if(data.getInstanceId().substring(0,2).equals("te")) {

            if(
                data.getParentId().substring(0,2).equals("om") &&
                data.getCompletedQuantity() == null
            ) {

                createTradeCommandFromOrderData(data);

            } else if(
                data.getParentId().substring(0,2).equals("te") &&
                data.getCompletedQuantity() != null
            ) {

                executeTrade(data);

            } else if(data.getPrice() == null) {

                createTradeExecutionFromOrderData(data);

            }

        }

    }

        private TradeCommand createTradeCommandFromOrderData(RawOrderData data) {
            TradeCommand newTradeCommand = tradeCommandRepository.addNewTradeCommandFromOrderData(data);
            this.message += TradeMessenger.tradeIsCreatedMessage(newTradeCommand);
            return newTradeCommand;
        }

        private TradeExecution createTradeExecutionFromOrderData(RawOrderData data) {
            TradeExecution newTradeExecution = tradeExecutionRepository.addNewTradeExecutionFromOrderData(data);
            this.message += TradeMessenger.tradeExecutionIsCreated(newTradeExecution);
            return newTradeExecution;
        }

        private void executeTrade(RawOrderData data) {
            TradeCommand executedTradeCommand = tradeCommandRepository.getTradeCommandById(data.getParentId());
            executedTradeCommand.executeTrade(data);
            tradeCommandRepository.updateAfterExecutionThroughOrderData(data);
            tradeExecutionRepository.updateExecutionFromOrderData(data);
            this.message += TradeMessenger.tradeIsExecutedMessage(executedTradeCommand, data);
        }

    public String getMessage() {
        return message;
    }
}
