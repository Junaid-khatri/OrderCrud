package com.spring_boot.order.order_crud.response;
import java.util.Date;


public class OrderResponse {

    private int id;
    private Date orderDate;
    private String place;
    private Date expectedDelivery;
    private int totalAmount;
    private String modeOfPayment;
    private String shipmentBy;
    private String orderStatus;

    public OrderResponse() {
    }

    public OrderResponse(int id, Date orderDate, String place, Date expectedDelivery, int totalAmount, String modeOfPayment, String shipmentBy, String orderStatus) {
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

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(Date expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public String getShipmentBy() {
        return shipmentBy;
    }

    public void setShipmentBy(String shipmentBy) {
        this.shipmentBy = shipmentBy;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
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
