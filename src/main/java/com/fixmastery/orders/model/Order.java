package com.fixmastery.orders.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Orders - This DTO will be used to
 */
//TODO: Verification of setMethods
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long	id	;
    private LocalDateTime datetimestamp	;
    private String	clientid	;
    private String	rootordid	;
    private String	parentordid	;
    private String	msgtype	;
    private String	orderid	;
    private String	systemid	;
    private int	instrument	;
    private String	ordstatus	;
    private String	ordtype	;
    private	String	venue	;
    private String	side	;
    private int	orderqty	;
    private int	cumqty	;
    private int	leavesqty	;
    private String	price	; // will be cast to BigDecimal
    private String	descr	;

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDatetimestamp() {
        return datetimestamp;
    }

    public void setDatetimestamp(String stringDateTime) {
        // TIMESTAMP 2016-07-18 07:55:00.000000
        String[] stringDateTimeArr = stringDateTime
                .split("^(\\d*)-(\\d*)-(\\d*)\\s(\\d*):(\\d*):(\\d*)");
        int year = Integer.parseInt(stringDateTimeArr[0]);
        int month = Integer.parseInt(stringDateTimeArr[1]);
        int day = Integer.parseInt(stringDateTimeArr[2]);
        int hour = Integer.parseInt(stringDateTimeArr[3]);
        int minute = Integer.parseInt(stringDateTimeArr[4]);
        int second = Integer.parseInt(stringDateTimeArr[5]);

        this.datetimestamp
            = LocalDateTime.of(year, month, day, hour, minute, second);
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getRootordid() {
        return rootordid;
    }

    public void setRootordid(String rootordid) {
        this.rootordid = rootordid;
    }

    public String getParentordid() {
        return parentordid;
    }

    public void setParentordid(String parentordid) {
        this.parentordid = parentordid;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getSystemid() {
        return systemid;
    }

    public void setSystemid(String systemid) {
        this.systemid = systemid;
    }

    public int getInstrument() {
        return instrument;
    }

    public void setInstrument(int instrument) {
        this.instrument = instrument;
    }

    public String getOrdstatus() {
        return ordstatus;
    }

    public void setOrdstatus(String ordstatus) {
        this.ordstatus = ordstatus;
    }

    public String getOrdtype() {
        return ordtype;
    }

    public void setOrdtype(String ordtype) {
        this.ordtype = ordtype;
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

    public int getOrderqty() {
        return orderqty;
    }

    public void setOrderqty(int orderqty) {
        this.orderqty = orderqty;
    }

    public int getCumqty() {
        return cumqty;
    }

    public void setCumqty(int cumqty) {
        this.cumqty = cumqty;
    }

    public int getLeavesqty() {
        return leavesqty;
    }

    public void setLeavesqty(int leavesqty) {
        this.leavesqty = leavesqty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", datetimestamp='" + datetimestamp + '\'' +
                ", clientid='" + clientid + '\'' +
                ", rootordid='" + rootordid + '\'' +
                ", parentordid='" + parentordid + '\'' +
                ", msgtype='" + msgtype + '\'' +
                ", orderid='" + orderid + '\'' +
                ", systemid='" + systemid + '\'' +
                ", instrument=" + instrument +
                ", ordstatus='" + ordstatus + '\'' +
                ", ordtype='" + ordtype + '\'' +
                ", venue='" + venue + '\'' +
                ", side='" + side + '\'' +
                ", orderqty=" + orderqty +
                ", cumqty=" + cumqty +
                ", leavesqty=" + leavesqty +
                ", price='" + price + '\'' +
                ", descr='" + descr + '\'' +
                '}';
    }
}
