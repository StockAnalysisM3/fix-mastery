package com.fixmastery.orders.dao.adapter;

import com.fixmastery.orders.dao.modeldao.TradeRepository;
import com.fixmastery.orders.dto.RawOrderData;
import com.fixmastery.orders.model.TradeCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TradeStrategy {

    @Autowired
    TradeRepository tradeRepository;

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
        // place one for updateParentTrade
    }

        private TradeCommand createTradeDirectlyFromOrderData(RawOrderData data) {
            TradeCommand newTradeCommand = tradeRepository.addNewTradeFromOrderData(data);
            this.message += tradeIsCreatedMessage(newTradeCommand);
            return newTradeCommand;
        }

            private String tradeIsCreatedMessage(TradeCommand tradeCommand) {
                return "Trade " + tradeCommand.getId() + " has been created\n" +
                        tradeCommand;
            }

        private void executeTrade(RawOrderData data) {
            TradeCommand executedTradeCommand = tradeRepository.getTradeById(data.getParentId());
            executedTradeCommand.executeTrade(data);
            this.message += tradeIsExecutedMessage(data);
        }

            private String tradeIsExecutedMessage(RawOrderData data) {
                return "Trade " + data.getParentId() + " has been executed\n" +
                    "Execution {" +
                        "Id: " + data.getInstanceId() +
                        " Instrument: " + data.getInstrument() +
                        " Quantity: " + data.getInitialQuantity() +
                        " Price: " + data.getPrice() +
                    "}";
            }

    public String getMessage() {
        return message;
    }
}
