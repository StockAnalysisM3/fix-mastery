package com.fixmastery.orders.dao.adapter;

import com.fixmastery.orders.dao.modeldao.TradeCommandRepository;
import com.fixmastery.orders.dto.RawOrderData;
import com.fixmastery.orders.misc.messenger.TradeMessenger;
import com.fixmastery.orders.model.TradeCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// The TradeStrategy will contain cases for the two Trade classes
@Component
public class TradeStrategy {

    @Autowired
    TradeCommandRepository tradeCommandRepository;

    private String message = "";

    public TradeStrategy() {}

    public void strategy(RawOrderData data) {
        this.message = "";
        if(
            data.getInstanceId().substring(0,2).equals("te") &&
            data.getParentId().substring(0,2).equals("om") &&
            data.getCompletedQuantity() == null
        ) {
            createTradeDirectlyFromOrderData(data);
        } else if(
                data.getInstanceId().substring(0,2).equals("te") &&
                data.getParentId().substring(0,2).equals("te") &&
                data.getCompletedQuantity() != null
        ) {
            executeTrade(data);
        }
    }

        private TradeCommand createTradeDirectlyFromOrderData(RawOrderData data) {
            TradeCommand newTradeCommand = tradeCommandRepository.addNewTradeCommandFromOrderData(data);
            this.message += TradeMessenger.tradeIsCreatedMessage(newTradeCommand);
            return newTradeCommand;
        }

        private void executeTrade(RawOrderData data) {
            TradeCommand executedTradeCommand = tradeCommandRepository.getTradeCommandById(data.getParentId());
            executedTradeCommand.executeTrade(data);
            tradeCommandRepository.updateAfterExecutionThroughOrderData(data);
            this.message += TradeMessenger.tradeIsExecutedMessage(executedTradeCommand, data);
        }

    public String getMessage() {
        return message;
    }
}
