package com.fixmastery.orders.model;

import com.fixmastery.categories.model.OrderStatus;
import com.fixmastery.categories.model.OrderType;
import com.fixmastery.categories.model.Side;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    @Id
    private String id; // orderId

    //TODO: Transform into User
    private String clientId;

    //TODO: Transform into Instrument
    private int instrument;

    private OrderStatus orderStatus;
    private OrderType orderType;

    //TODO: Transform into Venue
    private String venue;

    private Side side;
    private Long initialQuantity;
    private Long completedQuantity = 0L;
    private Long pendingQuantity;
    private Map<String, Trade> tradeList = new HashMap<>();

    /**
     * We will want to keep track of the original bid/ask price
     */
    private BigDecimal initialPrice;

    /**
     * We will use currentAveragePricePerUnit to determine order delta
     */
    private BigDecimal currentAveragePricePerUnit;
    private boolean fulfilled = false;

    public Order(
            String id,
            String clientId,
            int instrument,
            OrderStatus orderStatus,
            OrderType orderType,
            String venue,
            Side side,
            Long initialQuantity,
            Long completedQuantity,
            Long pendingQuantity,
            BigDecimal initialPrice
        ) {
        this.id = id;
        this.clientId = clientId;
        this.instrument = instrument;
        this.orderStatus = orderStatus;
        this.orderType = orderType;
        this.venue = venue;
        this.side = side;
        this.initialQuantity = initialQuantity;
        this.completedQuantity = completedQuantity;
        this.pendingQuantity = pendingQuantity;
        this.initialPrice = this.currentAveragePricePerUnit = initialPrice;
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

    public int getInstrument() {
        return instrument;
    }

    public void setInstrument(int instrument) {
        this.instrument = instrument;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Long getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(Long initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public Long getCompletedQuantity() {
        return completedQuantity;
    }

    public void setCompletedQuantity(Long completedQuantity) {
        this.completedQuantity = completedQuantity;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Long getPendingQuantity() {
        return pendingQuantity;
    }

    public void setPendingQuantity(Long pendingQuantity) {
        this.pendingQuantity = pendingQuantity;
    }

    public Map<String, Trade> getTradeList() {
        return tradeList;
    }

//    public void addTrade(Trade trade) {
//        this.tradeList.put(trade.getId(), trade);
//    }

    public BigDecimal getCurrentAveragePricePerUnit() {
        return currentAveragePricePerUnit;
    }

    public void setCurrentAveragePricePerUnit(BigDecimal currentAveragePricePerUnit) {
        this.currentAveragePricePerUnit = currentAveragePricePerUnit;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    @Override
    public String toString() {
        return "Order{" +
                "  id='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", instrument=" + instrument +
                ", orderStatus=" + orderStatus.getName() +
                ", orderType=" + orderType.getName() +
                ", venue='" + venue + '\'' +
                ", side=" + side.getName()    +
                ", initialQuantity=" + initialQuantity +
                ", completedQuantity=" + completedQuantity +
                ", price=" + initialPrice +
                '}';
    }
}
