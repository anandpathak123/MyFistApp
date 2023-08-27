package com.mycode.springbootrestfulwebservices.controller;

import com.mycode.springbootrestfulwebservices.entity.User;
import com.mycode.springbootrestfulwebservices.service.UserSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {
@Autowired
    private UserSerive userSerive;

    @PostMapping
    public ResponseEntity<User> creatUser(@RequestBody User user)
    {
    return new ResponseEntity<>(userSerive.createUser(user),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<User>> retrieveuser(@PathVariable("id") Long userId)
    {
       Optional<User> user=userSerive.getUserById(userId);
       return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/all")
    public  ResponseEntity<List<User>> getAllUser()
    {
        List<User> users=userSerive.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody User user){
        user.setId(userId);
        User updatedUser = userSerive.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userid)
    {
        userSerive.deleteUser(userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
