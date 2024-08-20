package com.ecommerce.user.controller;

import com.ecommerce.user.dto.UserDTO;
import com.ecommerce.user.entity.User;
import com.ecommerce.user.exception.UserNotFoundException;
import com.ecommerce.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> orders = userService.getAll();
        if(orders.isEmpty()){
            throw  new UserNotFoundException("Users not found");
        }
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(userService.getById(id));
        } catch (UserNotFoundException ex) {
            throw new UserNotFoundException("User with id " + id + "not found");
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }

    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        try {
            userService.getById(id);
            userService.deleteById(id);
            return ResponseEntity.accepted().build();
        } catch (UserNotFoundException ex) {
            throw  new UserNotFoundException("User with id " + id + " not found");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
