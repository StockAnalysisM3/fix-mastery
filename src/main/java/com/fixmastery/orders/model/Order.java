package com.fixmastery.orders.model;

import javax.persistence.Id;

public class Order {
    @Id
    private String id;
    private String clientId;
    private String orderStatusId;
    private String venue;

    public Order(
            String id,
            String clientId,
            String orderStatusId,
            String venue

        ) {
        this.id = id;
        this.clientId = clientId;
        this.orderStatusId = orderStatusId;
        this.venue = venue;
    }

    public String getId() {
        return id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


    public String getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(String orderStatusId) {
        this.orderStatusId = orderStatusId;
    }


    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void fulfillOrder() {
        this.orderStatusId = "2";
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", orderStatusId='" + orderStatusId + '\'' +
                ", venue='" + venue + '\'' +
                '}';
    }
}
