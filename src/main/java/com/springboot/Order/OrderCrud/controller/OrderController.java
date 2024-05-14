package com.springboot.Order.OrderCrud.controller;

import com.springboot.Order.OrderCrud.Entity.Order;
import com.springboot.Order.OrderCrud.Model.ExpectedDateModel;
import com.springboot.Order.OrderCrud.Model.OrderModel;
import com.springboot.Order.OrderCrud.Model.OrderStatusModel;
import com.springboot.Order.OrderCrud.Response.OrderResponse;
import com.springboot.Order.OrderCrud.Service.OrderService;
import com.springboot.Order.OrderCrud.Service.OrderServiceImple;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
public class OrderController {

    private static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @Autowired
    OrderResponse response;

    @PostMapping (value = "/createOrder", consumes  = "application/json", produces ="application/text")
    public String createOrder(@RequestBody @Valid OrderModel orderModel){
        logger.info(orderModel.toString());
        return orderService.createOrder(orderModel);
    }
    @PutMapping(value ="/updateExpectedDate",consumes = "application/json",produces="application/text")
    public String updateOrderExpectedDelivery(@RequestBody @Valid ExpectedDateModel dateModel){
        logger.info("updating Order id: "+ dateModel.getId() +" Expected delivery Date: "+dateModel.getExpectedDate());
        return orderService.updateOrderExpectedDelivery(dateModel);
    }
    @PutMapping(value = "/updateOrderStatus" ,consumes = "application/json" ,produces = "application/text")
    public String updateOrderStatus(@RequestBody @Valid OrderStatusModel statusModel){
        logger.info("updating Order status where id: "+statusModel.getId()+" status: "+statusModel.getOrderStatus());
        return orderService.updateOrderStatus(statusModel);
    }

    @DeleteMapping(value = "/deleteOrder", produces = "application/text")
    public String deleteOrder(@RequestParam  int id){
        logger.info("Deleting Order of id: "+id);
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
