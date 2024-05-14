package com.springboot.Order.OrderCrud.Repository;

import com.springboot.Order.OrderCrud.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
