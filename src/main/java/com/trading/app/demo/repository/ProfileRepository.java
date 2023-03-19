package com.trading.app.demo.repository;

import com.trading.app.demo.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository
        extends JpaRepository<Profile, Long> {
    Profile findByUserId(Long userId);
}
