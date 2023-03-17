package com.trading.app.demo.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Wire {

    //FIELDS
    @Id
    @SequenceGenerator(
            name = "wire_sequence_generator",
            sequenceName = "wire_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "wire_sequence_generator"
    )
    private long id;
    private long amount;
    private boolean withdrawal;

//    @Column(
//            name = "created_at",
//            nullable = false,
//            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
//    )
//    private LocalDateTime createdAt;
//


    // RELATIONSHIPS
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //CONSTRUCTORS
    public Wire(){}

    public Wire(long id, long amount, boolean withdrawal, User user) {
        this.id = id;
        this.amount = amount;
        this.withdrawal = withdrawal;
        this.user = user;
    }

    public Wire(long amount, boolean withdrawal, User user) {
        this.amount = amount;
        this.withdrawal = withdrawal;
        this.user = user;
    }

    // GETTERS AND SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public boolean isWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(boolean withdrawal) {
        this.withdrawal = withdrawal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Wire{" +
                "id=" + id +
                ", amount=" + amount +
                ", withdrawal=" + withdrawal +
                ", user=" + user +
                '}';
    }
}
