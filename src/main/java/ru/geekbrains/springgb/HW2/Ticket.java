package ru.geekbrains.springgb.HW2;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Ticket {
    private String number;
    private LocalDateTime createdAt;

    public Ticket(String number, LocalDateTime createdAt) {
        this.number = number;
        this.createdAt = createdAt;
    }
}


