package com.fixmastery.orders.model;

import com.fixmastery.categories.model.Side;

import javax.persistence.Id;
import java.math.BigDecimal;

public class Order {
    @Id
    private String id; // orderId

    //TODO: Transform into User
    private String clientId;
    private Integer instrument;

    private String orderStatusId;
    private String orderTypeId;

    //TODO: Transform into Venue
    private String venue;

    private String sideId;
    private Long initialQuantity;
    private Long completedQuantity = 0L;
    private Long pendingQuantity;

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
            String orderStatusId,
            String orderTypeId,
            String venue,
            String sideId,
            Long initialQuantity
        ) {
        this.id = id;
        this.clientId = clientId;
        this.instrument = instrument;
        this.orderStatusId = orderStatusId;
        this.orderTypeId = orderTypeId;
        this.venue = venue;
        this.sideId = sideId;
        this.initialQuantity = this.pendingQuantity = initialQuantity;
        this.completedQuantity = 0L;
        this.initialPrice = this.currentAveragePricePerUnit = BigDecimal.ZERO;
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

    public String getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(String orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(String orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getSideId() {
        return sideId;
    }

    public void setSideId(String sideId) {
        this.sideId = sideId;
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
                "id='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", instrument=" + instrument +
                ", orderStatusId='" + orderStatusId + '\'' +
                ", orderTypeId='" + orderTypeId + '\'' +
                ", venue='" + venue + '\'' +
                ", sideId='" + sideId + '\'' +
                ", initialQuantity=" + initialQuantity +
                ", completedQuantity=" + completedQuantity +
                ", pendingQuantity=" + pendingQuantity +
                ", initialPrice=" + initialPrice +
                ", currentAveragePricePerUnit=" + currentAveragePricePerUnit +
                ", fulfilled=" + fulfilled +
                '}';
    }
}
