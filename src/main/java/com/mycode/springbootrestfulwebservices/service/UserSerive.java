package com.mycode.springbootrestfulwebservices.service;

import com.mycode.springbootrestfulwebservices.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserSerive {

    User createUser(User user);

    Optional<User> getUserById(Long userId);

    List<User> getAllUsers();



    User updateUser(User user);

    void deleteUser(Long userId);
}
