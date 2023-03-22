package com.trading.app.demo.repository;


import com.trading.app.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


// IMPORTANT : As this repo extends JpaRepository it does NOT need
// the @Repository annotation it will even make the app crash.
public interface UserRepository
        //Long refers to the type of the ID used in the Student model:
        extends JpaRepository<User, Long> {

    @Query("SELECT s from User s where s.email=?1")
    Optional<User> findByEmail(String email);

}
