package com.fixmastery.orders.model;

import java.math.BigDecimal;

public class TradeExecution {
    private String id;
    private String cmdTradeId;
    private int instrumentId;
    private Long quantity;
    private BigDecimal price;

    public TradeExecution(String id, String cmdTradeId, int instrumentId, Long quantity, BigDecimal price) {
        this.id = id;
        this.cmdTradeId = cmdTradeId;
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

    public int getInstrumentId() {
        return instrumentId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "TradeExecution{" +
                "id='" + id + '\'' +
                ", mcdTradeId='" + cmdTradeId + '\'' +
                ", instrumentId='" + instrumentId + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
