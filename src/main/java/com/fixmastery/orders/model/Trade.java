package com.fixmastery.orders.model;

import com.fixmastery.categories.model.OrderStatus;
import com.fixmastery.categories.model.Side;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Trade {
    private String id;
    private LocalDateTime created;
    private LocalDateTime executed = null;
    private Order order;
    private int instrument;
    private OrderStatus tradeStatus;
    private Side side;
    private long quantity;
    private BigDecimal price;

    /**
     * This is the constructor for completed trade
     */
    public Trade(
            String id,
            LocalDateTime dateTimeStamp,
            Order order,
            int instrument,
            OrderStatus tradeStatus,
            Side side,
            long quantity
        ) {
        this.id = id;
        this.created = dateTimeStamp;
        this.order = order;
        this.instrument = instrument;
        this.tradeStatus = tradeStatus;
        this.side = side;
        this.quantity = quantity;
        this.price = null;
    }

    public void updateOrder(BigDecimal avgPrice){

        this.order.setPendingQuantity(
            this.order.getPendingQuantity() - this.quantity
        );

        this.order.setCompletedQuantity(
            this.order.getCompletedQuantity() + this.quantity
        );

        this.order.setCurrentAveragePricePerUnit(avgPrice);
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

    public OrderStatus getTradeStatus() {
        return tradeStatus;
    }

    public Side getSide() {
        return side;
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
                ", tradeStatus=" + tradeStatus.getName() +
                ", side=" + side.getName() +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
