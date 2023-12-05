package com.ex02.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex02.dto.User;

public interface IUserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);
}