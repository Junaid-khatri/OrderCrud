package com.spring_boot.order.order_crud.repository;

import com.spring_boot.order.order_crud.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
