package com.spring_boot.order.order_crud.controller;

import com.spring_boot.order.order_crud.service.OrderService;
import com.spring_boot.order.order_crud.entity.Order;
import com.spring_boot.order.order_crud.model.ExpectedDateModel;
import com.spring_boot.order.order_crud.model.OrderModel;
import com.spring_boot.order.order_crud.model.OrderStatusModel;
import com.spring_boot.order.order_crud.response.OrderResponse;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class OrderController {

    private static Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;
    private OrderResponse response;

    @Autowired
    public OrderController(OrderService orderService, OrderResponse response){
        this.orderService = orderService;
        this.response = response;
    }

    @PostMapping (value = "/createOrder", consumes  = "application/json", produces ="application/text")
    public String createOrder(@RequestBody @Valid OrderModel orderModel){

        logger.info("{}", orderModel);
        return orderService.createOrder(orderModel);
    }
    @PutMapping(value ="/updateExpectedDate",consumes = "application/json",produces="application/text")
    public String updateOrderExpectedDelivery(@RequestBody @Valid ExpectedDateModel dateModel){
        logger.info("updating Order id: {}  Expected delivery Date: {} ", dateModel.getId(), dateModel.getExpectedDate());
        return orderService.updateOrderExpectedDelivery(dateModel);
    }
    @PutMapping(value = "/updateOrderStatus" ,consumes = "application/json" ,produces = "application/text")
    public String updateOrderStatus(@RequestBody @Valid OrderStatusModel statusModel){
        logger.info("updating Order status where id: {} status: {} ", statusModel.getId(), statusModel.getOrderStatus());
        return orderService.updateOrderStatus(statusModel);
    }

    @DeleteMapping(value = "/deleteOrder", produces = "application/text")
    public String deleteOrder(@RequestParam  int id){
        logger.info("Deleting Order of id: {}",id);
        return orderService.deleteOrder(id);
    }
    @GetMapping(value = "/viewOrder")
    public OrderResponse viewOrder(@RequestParam int id){
        response = orderService.viewOrder(id);
        return response;
    }
    @GetMapping(value = "/viewOrders")
    public List<Order> viewAllOrder(){

        return orderService.viewAllOrder();
    }
}
