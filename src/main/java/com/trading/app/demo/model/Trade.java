package com.trading.app.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Table;

import java.time.LocalDateTime;

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
//    @Column(
//            name = "created_at",
//            nullable = false,
//            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
//    )
//    private LocalDateTime createdAt;



    // RELATIONSHIPS
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //CONSTRUCTORS
    public Trade(){}
    public Trade(long id, String symbol, Integer quantity, Integer openPriceInCent, Integer closePriceInCent, LocalDateTime openDateTime, LocalDateTime closeDateTime, boolean open, LocalDateTime createdAt, User user) {
        this.id = id;
        this.symbol = symbol;
        this.quantity = quantity;
        this.openPriceInCent = openPriceInCent;
        this.closePriceInCent = closePriceInCent;
        this.openDateTime = openDateTime;
        this.closeDateTime = closeDateTime;
        this.open = open;
        this.user = user;
    }

    public Trade(String symbol,
                 Integer quantity,
                 Integer openPriceInCent,
                 Integer closePriceInCent,
                 LocalDateTime openDateTime,
                 LocalDateTime closeDateTime,
                 boolean open,
                 User user) {

        this.symbol = symbol;
        this.quantity = quantity;
        this.openPriceInCent = openPriceInCent;
        this.closePriceInCent = closePriceInCent;
        this.openDateTime = openDateTime;
        this.closeDateTime = closeDateTime;
        this.open = open;
        this.user = user;
    }

    //GETTERS AND SETTERS


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOpenPriceInCent() {
        return openPriceInCent;
    }

    public void setOpenPriceInCent(Integer openPriceInCent) {
        this.openPriceInCent = openPriceInCent;
    }

    public Integer getClosePriceInCent() {
        return closePriceInCent;
    }

    public void setClosePriceInCent(Integer closePriceInCent) {
        this.closePriceInCent = closePriceInCent;
    }

    public LocalDateTime getOpenDateTime() {
        return openDateTime;
    }

    public void setOpenDateTime(LocalDateTime openDateTime) {
        this.openDateTime = openDateTime;
    }

    public LocalDateTime getCloseDateTime() {
        return closeDateTime;
    }

    public void setCloseDateTime(LocalDateTime closeDateTime) {
        this.closeDateTime = closeDateTime;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", quantity=" + quantity +
                ", openPriceInCent=" + openPriceInCent +
                ", closePriceInCent=" + closePriceInCent +
                ", openDateTime=" + openDateTime +
                ", closeDateTime=" + closeDateTime +
                ", open=" + open +
                ", user=" + user +
                '}';
    }
}
