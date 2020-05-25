package com.fixmastery.orders.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Orders - This DTO will be used to
 */
//TODO: Verification of setMethods
@Entity
@Table(name = "Orders")
public class OrderData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="datetimestamp")
    private LocalDateTime dateTimeStamp;

    @Column(name="clientid")
    @NotNull
    private String clientId;

    @Column(name="rootordid")
    private String orderId;

    @Column(name="parentordid")
    private String parentId;

    @Column(name="msgtype")
    private String messageType;

    @Column(name="orderid")
    private String instanceId;

    @Column(name = "systemid")
    private String systemId;

    // shall be edited once Instrument Entity is created
    private int instrument;

    @Column(name="ordstatus")
    private String orderStatus;

    @Column(name="ordtype")
    private String orderType;

    private String venue;

    @Column(name="side")
    private String side;

    /**
     * For initial, completed, and pending quantities,
     *      we are assuming values will be given in integers
     */

    @Column(name="orderqty", columnDefinition = "Integer default 0")
    private Long initialQuantity;

    @Column(name="cumqty", columnDefinition = "Integer default 0")
    private Long completedQuantity;

    @Column(name="leavesqty", columnDefinition = "Integer default 0")
    private Long pendingQuantity;

    @Column(columnDefinition = "Float default 0")
    private BigDecimal price;

    @Column(name = "descr")
    private String message;

    public OrderData() {
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDateTimeStamp() {
        return dateTimeStamp;
    }

    public String getClientId() {
        return clientId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getParentId() {
        return parentId;
    }

    public String getMessageType() {
        return messageType;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public String getSystemId() {
        return systemId;
    }

    public int getInstrument() {
        return instrument;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getVenue() {
        return venue;
    }

    public String getSide() {
        return side;
    }

    public Long getInitialQuantity() {
        return initialQuantity;
    }

    public Long getCompletedQuantity() {
        return completedQuantity;
    }

    public Long getPendingQuantity() {
        return pendingQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "OrderData{" +
                "id=" + id +
                ", dateTimeStamp=" + dateTimeStamp +
                ", clientId='" + clientId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", messageType='" + messageType + '\'' +
                ", instanceId='" + instanceId + '\'' +
                ", systemId='" + systemId + '\'' +
                ", instrument=" + instrument +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderType='" + orderType + '\'' +
                ", venue='" + venue + '\'' +
                ", side='" + side + '\'' +
                ", initialQuantity=" + initialQuantity +
                ", completedQuantity=" + completedQuantity +
                ", inProgressQuantity=" + pendingQuantity +
                ", price=" + price +
                ", message='" + message + '\'' +
                '}';
    }
}
