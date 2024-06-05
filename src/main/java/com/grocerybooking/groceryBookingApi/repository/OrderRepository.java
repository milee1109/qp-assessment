package com.grocerybooking.groceryBookingApi.repository;

import com.grocerybooking.groceryBookingApi.model.Order;
import com.grocerybooking.groceryBookingApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByUser(User user);
}
