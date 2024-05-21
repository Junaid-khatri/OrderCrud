package com.spring_boot.order.order_crud.service;

import com.spring_boot.order.order_crud.entity.Order;
import com.spring_boot.order.order_crud.model.ExpectedDateModel;
import com.spring_boot.order.order_crud.model.OrderModel;
import com.spring_boot.order.order_crud.model.OrderStatusModel;
import com.spring_boot.order.order_crud.repository.OrderRepository;
import com.spring_boot.order.order_crud.response.OrderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImple implements OrderService{

    private static final  String ERROR_MESSAGE = "Some Error Occurred Check Please With CodeBase";
    private static final String ID_NOT_EXIST_MSG = "Order id %d is not exist";
    private static final String ID_NOT_EXIST_MSG_LOGGER = "Order id {} is not exist";
    private static Logger logger = LoggerFactory.getLogger(OrderServiceImple.class);

    private final OrderRepository orderRepo;

    @Autowired
    public OrderServiceImple (OrderRepository orderRepo){
        this.orderRepo = orderRepo;
    }


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
            return ERROR_MESSAGE;
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
                     logger.warn(ID_NOT_EXIST_MSG_LOGGER, id);

                     return String.format(ID_NOT_EXIST_MSG, id);
            }
        }
        catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return ERROR_MESSAGE;
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
                     logger.warn(ID_NOT_EXIST_MSG_LOGGER, id);

                     return String.format(ID_NOT_EXIST_MSG, id);
            }
        }
        catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return ERROR_MESSAGE;
        }
    }

    @Override
    public String deleteOrder(int id) {
        try {
            if ((validateOrder(id))) {
                orderRepo.deleteById(id);
                logger.info("Order id: {} deleted",id);
                return "Order Deleted Successfully";

            } else {
                logger.warn(ID_NOT_EXIST_MSG_LOGGER, id);

                return String.format(ID_NOT_EXIST_MSG, id);

            }
        }
        catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return ERROR_MESSAGE;
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
                logger.warn(ID_NOT_EXIST_MSG_LOGGER, id);

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
