package ru.geekbrains.springgb.HW2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TicketBoard {
    @Autowired
    private final TicketNumberGenerator ticketNumberGenerator;

    public TicketBoard(TicketNumberGenerator ticketNumberGenerator) {
        this.ticketNumberGenerator = ticketNumberGenerator;
    }

    public Ticket newTicket() {
        String number = ticketNumberGenerator.createNewNumber();
        LocalDateTime now = LocalDateTime.now();
        return new Ticket(number, now);
    }
}


