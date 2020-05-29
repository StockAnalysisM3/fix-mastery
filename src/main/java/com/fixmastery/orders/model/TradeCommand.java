package com.fixmastery.orders.model;

import com.fixmastery.orders.dto.RawOrderData;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TradeCommand {
    private String id;
    private LocalDateTime created;
    private Order order;
    private int instrument;
    private String tradeStatusId = "0";
    private String sideId;
    private long targetQuantity;
    private long completedQuantity = 0;
    private long pendingQuantity = 0;
    private BigDecimal averagePrice = BigDecimal.ZERO;

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
    }

    public void updateParentOrder(RawOrderData data){
        this.order.setOrderStatusId(
            data.getOrderStatus()
        );
    }

    public void executeTrade(RawOrderData data) {
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

    public long getPendingQuantity() {
        return pendingQuantity;
    }

    public long getCompletedQuantity() {
        return completedQuantity;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setTradeStatusId(String tradeStatusId) {
        this.tradeStatusId = tradeStatusId;
    }

    public void setTargetQuantity(long targetQuantity) {
        this.targetQuantity = targetQuantity;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setPendingQuantity(long pendingQuantity) {
        this.pendingQuantity = pendingQuantity;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public void setCompletedQuantity(long completedQuantity) {
        this.completedQuantity = completedQuantity;
    }

    @Override
    public String toString() {
        return "TradeCommand{" +
                "id='" + id + '\'' +
                ", created=" + created +
                ", order=" + order +
                ", instrument=" + instrument +
                ", tradeStatusId='" + tradeStatusId + '\'' +
                ", sideId='" + sideId + '\'' +
                ", targetQuantity=" + targetQuantity +
                ", completedQuantity=" + completedQuantity +
                ", pendingQuantity=" + pendingQuantity +
                ", averagePrice=" + averagePrice +
                '}';
    }
}
