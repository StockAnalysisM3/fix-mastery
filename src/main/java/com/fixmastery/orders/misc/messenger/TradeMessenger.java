package com.fixmastery.orders.misc.messenger;

import com.fixmastery.orders.dto.RawOrderData;
import com.fixmastery.orders.model.TradeCommand;
import com.fixmastery.orders.model.TradeExecution;

public class TradeMessenger {

    public static String tradeIsCreatedMessage(TradeCommand tradeCommand) {
        return "Trade Command" + tradeCommand.getId() + " has been created\n" +
                tradeCommand;
    }

    public static String tradeIsExecutedMessage(TradeCommand tradeCommand, RawOrderData data) {
        return "Trade " + tradeCommand.getId() + " has been executed\n" +
                tradeCommandIsUpdatedMessage(tradeCommand) + "\n" +
                displayExecutionProperties(data);
    }

    public static String tradeCommandIsUpdatedMessage(TradeCommand tradeCommand) {
        return tradeCommand.toString();
    }

    public static String tradeExecutionIsCreated(TradeExecution tradeExecution) {
        return  "TradeExecution " + tradeExecution.getId() + " is initialized\n" +
                "Part of Command " + tradeExecution.getCmdTradeId() + "\n" +
                tradeExecution.toString();
    }

    public static String displayExecutionProperties(RawOrderData data) {
        return  "Execution {" +
                    " Id: " + data.getInstanceId() +
                    " Instrument: " + data.getInstrument() +
                    " Quantity: " + data.getInitialQuantity() +
                    " Price: " + data.getPrice() +
                "}";
    }

}
