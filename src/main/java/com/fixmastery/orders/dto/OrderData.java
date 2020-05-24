package com.fixmastery.orders.dto;

import com.fixmastery.categories.model.MessageType;
import com.fixmastery.categories.model.OrderStatus;
import com.fixmastery.categories.model.OrderType;
import com.fixmastery.categories.model.Side;

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

//    private long id;
//    private LocalDateTime datetimestamp;
//    private String clientid;
//    private String rootordid;
//    private String parentordid;
//    private String msgtype;
//    private String orderid;
//    private String systemid;
//    private int instrument;
//    private String ordstatus;
//    private String ordtype;
//    private String venue;
//    private String side;
//    private int orderqty;
//    private int cumqty;
//    private int leavesqty;
//    private String price; // will be cast to BigDecimal
//    private String descr;

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

    @Column(name="orderqty", columnDefinition = "Integer default 0")
    private Long initialQuantity;

    @Column(name="cumqty", columnDefinition = "Integer default 0")
    private Long completedQuantity;

    @Column(name="leavesqty", columnDefinition = "Integer default 0")
    private Long inProgressQuantity;

    @Column(columnDefinition = "Float default 0")
    private BigDecimal price;

    @Column(name = "descr")
    private String message;

    public OrderData() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateTimeStamp() {
        return dateTimeStamp;
    }

    public void setDateTimeStamp(String stringDateTime) {
        // TIMESTAMP 2016-07-18 07:55:00.000000
        String[] stringDateTimeArr = stringDateTime
                .split("(\\d*)-(\\d*)-(\\d*)\\s(\\d*):(\\d*):(\\d*)");
        int year = Integer.parseInt(stringDateTimeArr[0]);
        int month = Integer.parseInt(stringDateTimeArr[1]);
        int day = Integer.parseInt(stringDateTimeArr[2]);
        int hour = Integer.parseInt(stringDateTimeArr[3]);
        int minute = Integer.parseInt(stringDateTimeArr[4]);
        int second = Integer.parseInt(stringDateTimeArr[5]);

        this.dateTimeStamp
            = LocalDateTime.of(year, month, day, hour, minute, second);
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public int getInstrument() {
        return instrument;
    }

    public void setInstrument(int instrument) {
        this.instrument = instrument;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public Long getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(Long initialQuantity) {
        this.initialQuantity = initialQuantity == null ? 0 : initialQuantity;
    }

    public Long getCompletedQuantity() {
        return completedQuantity;
    }

    public void setCompletedQuantity(Long completedQuantity) {
        this.completedQuantity = completedQuantity == null ? 0 : completedQuantity;
    }

    public Long getInProgressQuantity() {
        return inProgressQuantity;
    }

    public void setInProgressQuantity(Long inProgressQuantity) {
        this.inProgressQuantity = inProgressQuantity == null ? 0 : inProgressQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = new BigDecimal(Float.toString(price));
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
                ", inProgressQuantity=" + inProgressQuantity +
                ", price=" + price +
                ", message='" + message + '\'' +
                '}';
    }
}
