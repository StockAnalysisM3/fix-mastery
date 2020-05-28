package com.fixmastery.orders.dao;

import com.fixmastery.orders.dto.RawOrderData;
import com.fixmastery.orders.model.Message;
import com.fixmastery.orders.model.Order;
import com.fixmastery.orders.model.TradeCommand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawOrderDataRepository extends CrudRepository<RawOrderData, Long> {

    default void saveMessageRawAsOrderData(Message message){
        //TODO: Implement as phase2
    }

    default void saveTradeRawAsOrderData(TradeCommand tradeCommand) {
        //TODO: Implement as phase2
    }

    default void saveOrderRawAsOrderData(Order order) {
        //TODO: Implement as phase2
    }

}
