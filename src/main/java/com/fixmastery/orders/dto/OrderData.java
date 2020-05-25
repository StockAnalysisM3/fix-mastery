package com.fixmastery.orders.dto;

import com.fixmastery.categories.model.MessageType;
import com.fixmastery.categories.model.OrderStatus;
import com.fixmastery.categories.model.OrderType;
import com.fixmastery.categories.model.Side;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
