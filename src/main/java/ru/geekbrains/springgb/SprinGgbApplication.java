package ru.geekbrains.springgb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SprinGgbApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SprinGgbApplication.class, args);

        TicketBoard ticket = context.getBean(TicketBoard.class);
        System.out.println(ticket.newTicket());
        System.out.println(ticket.newTicket());
        System.out.println(ticket.newTicket());
    }
}
