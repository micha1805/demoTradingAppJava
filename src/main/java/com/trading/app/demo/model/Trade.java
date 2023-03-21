package com.trading.app.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;
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

    public int getClosedPNL() throws IllegalArgumentException{
        if(open) throw new IllegalArgumentException("trade still open, cannot calculate closed PnL");
        return closePriceInCent - openPriceInCent;
    }


    // RELATIONSHIPS
    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude // prevent infinite loops
    private User user;

}
