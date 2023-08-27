package com.mycode.springbootrestfulwebservices.service.Implentation;

import com.mycode.springbootrestfulwebservices.entity.User;
import com.mycode.springbootrestfulwebservices.repository.UserRepository;
import com.mycode.springbootrestfulwebservices.service.UserSerive;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceImplementation implements UserSerive {
    @Autowired
    private UserRepository userRepo;
    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepo.findById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepo.findById(user.getId()).get();
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepo.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {

        userRepo.deleteById(userId);

    }
}
