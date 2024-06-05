package com.grocerybooking.groceryBookingApi.repository;

import com.grocerybooking.groceryBookingApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
