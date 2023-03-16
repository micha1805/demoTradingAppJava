package com.trading.app.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Wire {
    @Id
    long id;
    // Many-to-one relationship with User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Wire(){}
}
