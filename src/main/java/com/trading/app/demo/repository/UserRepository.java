package com.trading.app.demo.repository;


import com.trading.app.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        //Long refers to the type of the ID used in the Student model:
        extends JpaRepository<User, Long> {

    @Query("SELECT s from User s where s.email=?1")
    Optional<User> findUserByEmail(String email);



}
