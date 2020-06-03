package com.fixmastery.orders.misc.messenger;

import com.fixmastery.orders.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMessenger {

    public static String orderIsCreatedMessage(Order order) {
        return "Order " + order.getId() + " has been created\n" +
                order;
    }

    public static String orderIsUpdatedMessage(Order order) {
        return "Order " + order.getId() + " has been updated\n" +
                order;
    }

    public static String orderHasBeenFulfilledMessage(Order order) {
        return "\nOrder " + order.getId() + " has been fulfilled\n";
    }
}
