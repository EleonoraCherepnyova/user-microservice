package com.ecommerce.user.service;

import com.ecommerce.user.dto.UserDTO;
import com.ecommerce.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDTO> getAll();

    UserDTO getById(Long id);

    User createUser(User user);

    void deleteById(Long id);

}
