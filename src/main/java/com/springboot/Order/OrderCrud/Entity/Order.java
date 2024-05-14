package com.springboot.Order.OrderCrud.Entity;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orderDetail")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date orderDate;
    private String place;
    private Date expectedDelivery;
    private int totalAmount;
    private String modeOfPayment;
    private String shipmentBy;
    private String orderStatus;

    public Order() {
    }

    public Order(Date orderDate, String place, Date expectedDelivery, int totalAmount, String modeOfPayment, String shipmentBy, String orderStatus) {
        this.id = id;
        this.orderDate = orderDate;
        this.place = place;
        this.expectedDelivery = expectedDelivery;
        this.totalAmount = totalAmount;
        this.modeOfPayment = modeOfPayment;
        this.shipmentBy = shipmentBy;
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getPlace() {
        return place;
    }

    public Date getExpectedDelivery() {
        return expectedDelivery;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public String getShipmentBy() {
        return shipmentBy;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setExpectedDelivery(Date expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public void setShipmentBy(String shipmentBy) {
        this.shipmentBy = shipmentBy;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", place='" + place + '\'' +
                ", expectedDelivery=" + expectedDelivery +
                ", totalAmount=" + totalAmount +
                ", modeOfPayment='" + modeOfPayment + '\'' +
                ", shipmentBy='" + shipmentBy + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
