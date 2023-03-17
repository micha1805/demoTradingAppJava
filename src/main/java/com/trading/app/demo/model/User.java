package com.trading.app.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
// IMPORTANT : Table MUST be renamed because user is a reserved keyword in Postgresql
@Table(
        name="users",
        uniqueConstraints = {
                @UniqueConstraint(
                        name="student_email_username_unique",
                        columnNames = {"email", "username"}
                )
        }
)
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

    @Column(
            name="username",
            nullable = false
    )
    private String username;
    @Column(
            nullable = false
    )
    private String email;
    private String password;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;



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

    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
