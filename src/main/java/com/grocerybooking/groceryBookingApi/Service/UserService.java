package com.grocerybooking.groceryBookingApi.Service;

import com.grocerybooking.groceryBookingApi.model.User;
import com.grocerybooking.groceryBookingApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
