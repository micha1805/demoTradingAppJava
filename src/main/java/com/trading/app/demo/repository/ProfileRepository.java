package com.trading.app.demo.repository;

import com.trading.app.demo.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfileRepository
        extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUserId(Long userId);
}
