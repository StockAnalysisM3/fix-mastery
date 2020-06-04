package com.fixmastery.orders.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TradeExecution {
    private String id;
    private String cmdTradeId;
    private LocalDateTime dateTimeStamp;
    private int instrumentId;
    private Long quantity;
    private BigDecimal price;

    public TradeExecution(String id, String cmdTradeId, LocalDateTime dateTimeStamp, int instrumentId, Long quantity, BigDecimal price) {
        this.id = id;
        this.cmdTradeId = cmdTradeId;
        this.dateTimeStamp = dateTimeStamp;
        this.instrumentId = instrumentId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getCmdTradeId() {
        return cmdTradeId;
    }

    public LocalDateTime getDateTimeStamp() {
        return dateTimeStamp;
    }

    public int getInstrumentId() {
        return instrumentId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setDateTimeStamp(LocalDateTime dateTimeStamp) {
        this.dateTimeStamp = dateTimeStamp;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TradeExecution{" +
                "id='" + id + '\'' +
                ", cmdTradeId='" + cmdTradeId + '\'' +
                ", dateTimeStamp=" + dateTimeStamp +
                ", instrumentId=" + instrumentId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
