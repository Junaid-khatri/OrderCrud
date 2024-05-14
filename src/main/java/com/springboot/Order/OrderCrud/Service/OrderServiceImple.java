package com.springboot.Order.OrderCrud.Service;

import com.springboot.Order.OrderCrud.Entity.Order;
import com.springboot.Order.OrderCrud.Model.ExpectedDateModel;
import com.springboot.Order.OrderCrud.Model.OrderModel;
import com.springboot.Order.OrderCrud.Model.OrderStatusModel;
import com.springboot.Order.OrderCrud.Repository.OrderRepository;
import com.springboot.Order.OrderCrud.Response.OrderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImple implements OrderService{

    private static Logger logger = LoggerFactory.getLogger(OrderServiceImple.class);

    @Autowired
    OrderRepository orderRepo;


    @Override
    public String createOrder(OrderModel orderModel) {

        Order order = new Order(
                orderModel.getOrderDate(),orderModel.getPlace(),
                orderModel.getExpectedDelivery(),orderModel.getTotalAmount(),
                orderModel.getModeOfPayment(),orderModel.getShipmentBy(),orderModel.getOrderStatus()
        );
        try {

            if (!(validateOrder(order.getId()))) {
                logger.info("Order saved");
                orderRepo.save(order);

                return "Order Saved Successfully";
            } else {
                logger.warn("Order already exist, Not saved!!");
                return "Sorry, Order Already Exists";
            }
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return "Some Error Occurred Check Please With CodeBase";
        }

    }

    @Override
    public String updateOrderExpectedDelivery(ExpectedDateModel dateModel) {

        int id = dateModel.getId();

        try {
                 if ((validateOrder(id))) {
                Order order = orderRepo.findById(id).get();
                order.setExpectedDelivery(dateModel.getExpectedDate());
                orderRepo.save(order);
                logger.info("Order "+id+" updated with new expected date "+dateModel.getExpectedDate());
                return "Order updated Successfully";

            } else {
                     logger.warn("Order id " + id + " is not exist");
                return "Order id " + id + " is not exist";
            }
        }
        catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return "Some Error Occurred Check Please With CodeBase";
        }

    }

    @Override
    public String updateOrderStatus(OrderStatusModel statusModel) {
        int id = statusModel.getId();
        try {
                 if ((validateOrder(id))) {
                Order order = orderRepo.findById(id).get();
                order.setOrderStatus(statusModel.getOrderStatus());
                orderRepo.save(order);
                logger.info("Order "+id+" updated with status "+statusModel.getOrderStatus());
                return "Order updated Successfully";

            } else {
                     logger.warn("Order id " + id + " is not exist");
                     return "Order id " + id + " is not exist";
            }
        }
        catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return "Some Error Occurred Check Please With CodeBase";
        }
    }

    @Override
    public String deleteOrder(int id) {
        try {
            if ((validateOrder(id))) {
                orderRepo.deleteById(id);
                logger.info("Order id: "+id+" deleted");
                return "Order Deleted Successfully";

            } else {
                logger.warn("Order id " + id + " is not exist");
                return "Order id " + id + " is not exist";
            }
        }
        catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return "Some Error Occurred Check Please With CodeBase";
        }
    }

    @Override
    public OrderResponse viewOrder(int id) {
        try {
            if ((validateOrder(id))) {
                Order order = orderRepo.findById(id).get();
                OrderResponse response = new OrderResponse
                        (
                        order.getId(),order.getOrderDate(),order.getPlace(),
                        order.getExpectedDelivery(),order.getTotalAmount(),
                        order.getModeOfPayment(),order.getShipmentBy(),
                        order.getOrderStatus()
                );
                logger.info(response.toString());
                return response;

            } else {
                logger.warn("Order id " + id + " is not exist");
                return null;
            }
        }
        catch(Exception e){
            logger.info("inside catch");
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Order> viewAllOrder() {
        try {
            List<Order> orderList = orderRepo.findAll();
            logger.info("All Orders all fetched");
            return orderList;
        }
        catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public boolean validateOrder(int id) {
        return orderRepo.existsById(id);
    }
}
