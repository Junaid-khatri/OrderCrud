package com.spring_boot.order.order_crud.service;

import com.spring_boot.order.order_crud.entity.Order;
import com.spring_boot.order.order_crud.model.ExpectedDateModel;
import com.spring_boot.order.order_crud.model.OrderModel;
import com.spring_boot.order.order_crud.model.OrderStatusModel;
import com.spring_boot.order.order_crud.response.OrderResponse;

import java.util.List;

public interface OrderService {

    String createOrder(OrderModel orderModel);
    String updateOrderExpectedDelivery(ExpectedDateModel dateModel);
    String updateOrderStatus(OrderStatusModel statusModel);
    String deleteOrder(int id);
    OrderResponse viewOrder(int id);
    List<Order> viewAllOrder();
    boolean validateOrder(int id);
}
