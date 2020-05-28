package com.fixmastery.orders.model;

import com.fixmastery.orders.dto.RawOrderData;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TradeCommand {
    private String id;
    private LocalDateTime created;
    private LocalDateTime executed = null;
    private Order order;
    private int instrument;
    private String tradeStatusId = "0";
    private String sideId;
    private long targetQuantity;
    private long completedQuantity;
    private BigDecimal averagePrice;

    public TradeCommand(
            String id,
            LocalDateTime dateTimeStamp,
            Order order,
            int instrument,
            String tradeStatusId,
            String sideId,
            long targetQuantity
        ) {
        this.id = id;
        this.created = dateTimeStamp;
        this.order = order;
        this.instrument = instrument;
        this.tradeStatusId = tradeStatusId;
        this.sideId = sideId;
        this.targetQuantity = targetQuantity;
        this.averagePrice = null;
    }

    public void updateParentOrder(RawOrderData data){
        this.order.setOrderStatusId(
            data.getOrderStatus()
        );
    }

    public void executeTrade(RawOrderData data) {
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

    public long getTargetQuantity() {
        return targetQuantity;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public long getCompletedQuantity() {
        return completedQuantity;
    }

    public void setCompletedQuantity(long completedQuantity) {
        this.completedQuantity = completedQuantity;
    }

    @Override
    public String toString() {
        return "TradeCommand{" +
                "id='" + id + '\'' +
                ", created=" + created +
                ", executed=" + executed +
                ", order=" + order +
                ", instrument=" + instrument +
                ", tradeStatusId='" + tradeStatusId + '\'' +
                ", sideId='" + sideId + '\'' +
                ", targetQuantity=" + targetQuantity +
                ", completedQuantity=" + completedQuantity +
                ", averagePrice=" + averagePrice +
                '}';
    }
}
