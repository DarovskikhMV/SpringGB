package ru.geekbrains.springgb.HW2;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TicketNumberGenerator {

    private static final String PREFIX = "Ticket #";

    public String createNewNumber() {
        return PREFIX + UUID.randomUUID().toString();
    }
}
