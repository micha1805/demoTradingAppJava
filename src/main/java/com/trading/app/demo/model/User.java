package com.trading.app.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
// IMPORTANT : Table MUST be renamed because user is a reserved keyword in Postgresql
@Table(name="users")
public class User {


    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )

    private Long id;
    private String email;
    private String password;


// THE FOLLOWING IS NOT WORKING :::
//
//
//
//    @Column(
//            name = "created_at",
//            nullable = false,
//            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
//    )
//    private LocalDateTime createdAt;



    // relationships with other models
    // One-to-one relationship with Profile
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    // One-to-many relationship with Wire
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Wire> wires;

    // One-to-many relationship with Trade
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Trade> trades;


    // CONSTRUCTORS
    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
