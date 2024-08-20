package com.ecommerce.user.service;

import com.ecommerce.user.dto.UserDTO;
import com.ecommerce.user.entity.User;
import com.ecommerce.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService  {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO getById(Long id) {
        return userRepository.findById(id).map(UserDTO::new)
                .orElseThrow(()-> new RuntimeException("order with id [%s] not found".formatted(id)));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.findById(id);
        userRepository.deleteById(id);

    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(UserDTO::new).toList();
    }
}


