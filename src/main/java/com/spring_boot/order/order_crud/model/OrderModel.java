package com.spring_boot.order.order_crud.model;

import javax.validation.constraints.*;

import java.util.Date;

public class OrderModel {

    @PastOrPresent(message = "Order place date should be today or past date")
    private Date orderDate;

    @NotBlank(message = "place field should not be empty")
    private String place;

    @FutureOrPresent(message = "Delivery date should be in future or today")
    private Date expectedDelivery;

    @NotNull(message ="Enter some amount")
    private int totalAmount;

    @NotBlank(message ="mode of payment should be defined")
    private String modeOfPayment;

    @NotBlank(message ="Shipment details should be defined")
    private String shipmentBy;
    private String orderStatus;

    public OrderModel() {
    }

    public OrderModel(Date orderDate, String place, Date expectedDelivery, int totalAmount, String modeOfPayment, String shipmentBy, String orderStatus) {

        this.orderDate = orderDate;
        this.place = place;
        this.expectedDelivery = expectedDelivery;
        this.totalAmount = totalAmount;
        this.modeOfPayment = modeOfPayment;
        this.shipmentBy = shipmentBy;
        this.orderStatus = orderStatus;
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
        return "OrderModel{" +
                "orderDate=" + orderDate +
                ", place='" + place + '\'' +
                ", expectedDelivery=" + expectedDelivery +
                ", totalAmount=" + totalAmount +
                ", modeOfPayment='" + modeOfPayment + '\'' +
                ", shipmentBy='" + shipmentBy + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
