package com.trading.app.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data // for the getters and setters and toString method
@Builder // to get the builders
@NoArgsConstructor // to get the no arg constructor
@AllArgsConstructor //to get the all arg constructor
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
    // Note : I should add a created_at field, in every model by the way

    // RELATIONSHIPS
    // One-to-one relationship with Profile
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    // One-to-many relationship with Wire
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Wire> wires;

    // One-to-many relationship with Trade
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Trade> trades;
}
