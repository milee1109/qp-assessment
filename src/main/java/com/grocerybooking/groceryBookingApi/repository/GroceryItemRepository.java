package com.grocerybooking.groceryBookingApi.repository;

import com.grocerybooking.groceryBookingApi.model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryItemRepository extends JpaRepository<GroceryItem,Long> {
}
