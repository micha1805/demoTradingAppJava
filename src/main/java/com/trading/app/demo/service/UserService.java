package com.trading.app.demo.service;

import com.trading.app.demo.httpresponsesformat.CurrentBalanceResponse;
import com.trading.app.demo.model.User;
import com.trading.app.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;


    public List<User> getUsers(){return userRepository.findAll();};

    public User getUserById(Long userId){

        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "User with Id=" + userId + " does not exist"
                ));
    }

    public Optional<User> getUserByAuthHeader(String authHeader){

        return userRepository.findByEmail(jwtService.extractUsername(authHeader.substring(7)));
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public Integer getCurrentBalance(User user){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(user);
        Integer currentBalance = 123144;
        return currentBalance;
    }
}
