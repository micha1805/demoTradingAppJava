package com.trading.app.demo.service;

import com.trading.app.demo.model.User;
import com.trading.app.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getUsers(){return userRepository.findAll();};

    public User getUserById(Long userId){

        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "User with Id=" + userId + " does not exist"
                ));
    }

}
