package com.fixmastery.orders.dao;

import com.fixmastery.orders.dto.OrderData;
import com.fixmastery.orders.model.Message;
import com.fixmastery.orders.model.Order;
import com.fixmastery.orders.model.Trade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface OrderDataRepository extends CrudRepository<OrderData, Long> {

//    Map<Integer, Map<String, ?>> loadAsModel();

    default void saveMessageAsOrderData(Message message){
        //TODO: Implement
    }

    default void saveTradeAsOrderData(Trade trade) {
        //TODO: Implement
    }

    default void saveOrderAsOrderData(Order order) {
        //TODO: Implement
    }

}
