package com.trading.app.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    // RELATIONSHIPS
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
