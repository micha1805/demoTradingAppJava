package com.trading.app.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Trade {

    //FIELDS
    @Id
    @SequenceGenerator(
            name = "trade_sequence+generator",
            sequenceName = "trade_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trade_sequence_generator"
    )
    private long id;
    private String symbol;
    private Integer quantity;
    private Integer openPriceInCent;
    private Integer closePriceInCent;
    private LocalDateTime openDateTime;
    private LocalDateTime closeDateTime;
    private boolean open;


    // RELATIONSHIPS
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
