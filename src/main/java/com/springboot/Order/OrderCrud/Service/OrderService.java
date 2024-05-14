package com.springboot.Order.OrderCrud.Service;

import com.springboot.Order.OrderCrud.Entity.Order;
import com.springboot.Order.OrderCrud.Model.ExpectedDateModel;
import com.springboot.Order.OrderCrud.Model.OrderModel;
import com.springboot.Order.OrderCrud.Model.OrderStatusModel;
import com.springboot.Order.OrderCrud.Response.OrderResponse;

import java.util.Date;
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
