package com.trading.app.demo.service;

import com.trading.app.demo.httpresponsesformat.CurrentBalanceResponse;
import com.trading.app.demo.model.Trade;
import com.trading.app.demo.model.User;
import com.trading.app.demo.model.Wire;
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

    public void update(User user) {
        userRepository.save(user);
    }

    public Integer getCurrentBalance(User user){

        int currentBalance = 0;

        int depositsTotal = user.getWires().stream()
                .filter(w -> w.getAmount() > 0)
                .mapToInt(Wire::getAmount)
                .sum();
        int withdrawalTotal = user.getWires().stream()
                .filter(w -> w.getAmount() <=0 )
                .mapToInt(Wire::getAmount)
                .sum();
        int cash = depositsTotal - withdrawalTotal;
        int closedProfitLoss = user.getTrades()
                .stream().filter(t -> !t.isOpen())
                .mapToInt(Trade::getClosedPNL)
                .sum();
        // I could add openPNL but for the sake of simplicity I wont.
        // if I wanted I would have to grab current symbol price for each trade
        currentBalance = cash + closedProfitLoss;
        return currentBalance;
    }

    public User getUserFromHeader(String authHeader){
        Optional<User> currentUser = userRepository
                .findByEmail(jwtService.extractUsername(authHeader.substring(7)));

        User user;

        if(currentUser.isPresent()){
            user = currentUser.get();
            return user;
        }else{
            throw new IllegalArgumentException("User not found");
        }
    }


}
