package com.ex02.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex02.dto.User;
import com.ex02.dao.IUserDAO;


@Service
public class UserService implements IUserService{

    @Autowired
    private IUserDAO userRepository;

    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    @Override
    public boolean authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
    
    public User updateUserProfile(User updatedUser) {
        return userRepository.save(updatedUser);
    }


}

