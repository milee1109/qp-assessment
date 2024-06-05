package com.grocerybooking.groceryBookingApi.Service;

import com.grocerybooking.groceryBookingApi.model.GroceryItem;
import com.grocerybooking.groceryBookingApi.model.Order;
import com.grocerybooking.groceryBookingApi.model.User;
import com.grocerybooking.groceryBookingApi.repository.GroceryItemRepository;
import com.grocerybooking.groceryBookingApi.repository.OrderRepository;
import com.grocerybooking.groceryBookingApi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private GroceryItemRepository groceryItemRepository;
    @Autowired
    private GroceryItemService groceryItemService;

    public Order placeOrder(User user, List<GroceryItem> items) {
        Order order = new Order();
        order.setUser(user);
        order.setGroceryItemList(items);
        order.setLocalDateTime(LocalDateTime.now());
        order.setOrderCompleted(false);
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }
}
