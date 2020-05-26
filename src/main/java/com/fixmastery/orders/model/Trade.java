package com.fixmastery.orders.model;

import com.fixmastery.orders.dto.OrderData;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Trade {
    private String id;
    private LocalDateTime created;
    private LocalDateTime executed = null;
    private Order order;
    private int instrument;
    private String tradeStatusId;
    private String sideId;
    private long quantity;
    private BigDecimal price;

    /**
     * This is the constructor for an impending trade
     */
    public Trade(
            String id,
            LocalDateTime dateTimeStamp,
            Order order,
            int instrument,
            String tradeStatusId,
            String sideId,
            long quantity
        ) {
        this.id = id;
        this.created = dateTimeStamp;
        this.order = order;
        this.instrument = instrument;
        this.tradeStatusId = tradeStatusId;
        this.sideId = sideId;
        this.quantity = quantity;
        this.price = null;
    }

    public void updateOrder(OrderData data){
        BigDecimal avgPrice = data.getPrice();

        this.order.setPendingQuantity(
            data.getPendingQuantity()
        );

        this.order.setCompletedQuantity(
            data.getCompletedQuantity()
        );

        this.order.setCurrentAveragePricePerUnit(avgPrice);
    }

    public void executeTrade(OrderData data) {
        this.executed = data.getDateTimeStamp();
        this.tradeStatusId = data.getOrderStatus();
    }

    public String getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public int getInstrument() {
        return instrument;
    }

    public String getTradeStatusId() {
        return tradeStatusId;
    }

    public String getSideId() {
        return sideId;
    }

    public long getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id='" + id + '\'' +
                ", created=" + created +
                ", executed=" + executed +
                ", order=" + order +
                ", instrument='" + instrument + '\'' +
                ", tradeStatus=" + tradeStatusId +
                ", side=" + sideId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
