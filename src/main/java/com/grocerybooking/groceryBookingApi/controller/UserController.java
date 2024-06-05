package com.grocerybooking.groceryBookingApi.controller;
import com.grocerybooking.groceryBookingApi.Service.GroceryItemService;
import com.grocerybooking.groceryBookingApi.Service.OrderService;
import com.grocerybooking.groceryBookingApi.Service.UserService;
import com.grocerybooking.groceryBookingApi.model.GroceryItem;
import com.grocerybooking.groceryBookingApi.model.Order;
import com.grocerybooking.groceryBookingApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private GroceryItemService groceryItemService;

    @GetMapping("/order/id")
    public ResponseEntity<Order>  getOrderById(@PathVariable Long id){
       Order order= orderService.getOrderById(id);
       return ResponseEntity.ok().body(order);
    }
    @GetMapping("/grocery")
    public ResponseEntity<List<GroceryItem>> getAllItems(){
      List<GroceryItem> groceryItems=  groceryItemService.getAllItems();
      return ResponseEntity.ok().body(groceryItems);
    }

    @PostMapping("/order")
    public ResponseEntity<Order> placeOrder(@RequestBody List<GroceryItem> item,@RequestParam Long userId){
        User user=userService.getUserById(userId);
        Order order=orderService.placeOrder(user,item);
        return ResponseEntity.ok().body(order);
    }
}
