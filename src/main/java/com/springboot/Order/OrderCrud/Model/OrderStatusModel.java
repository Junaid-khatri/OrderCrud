package com.springboot.Order.OrderCrud.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class OrderStatusModel {

    int id;
    @NotBlank(message="provide order status Detail")
    String orderStatus;

    public OrderStatusModel() {
    }

    public OrderStatusModel(int id, String orderStatus) {
        this.id = id;
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrderStatusModel{" +
                "id=" + id +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
