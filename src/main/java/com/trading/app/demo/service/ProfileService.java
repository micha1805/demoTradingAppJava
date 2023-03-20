package com.trading.app.demo.service;

import com.trading.app.demo.model.Profile;
import com.trading.app.demo.model.User;
import com.trading.app.demo.repository.ProfileRepository;
import com.trading.app.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private ProfileRepository profileRepository;
    private UserRepository userRepository;

    @Autowired
    public ProfileService(
            ProfileRepository profileRepository,
            UserRepository userRepository){
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    };


    public Profile findByUserId(Long userId) {
        return profileRepository.findByUserId(userId)
                    .orElseThrow(() -> new IllegalStateException("Profile with Id=" + userId + " does not exist" ));
    }

}
