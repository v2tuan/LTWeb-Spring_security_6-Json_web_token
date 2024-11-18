package com.security.service;

import com.security.entity.User;
import com.security.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor-based injection for userRepository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to get all users
    public List<User> allUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}
