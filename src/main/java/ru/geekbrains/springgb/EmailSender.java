package ru.geekbrains.springgb;

import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    public void sendEmail(String subject, String body, String recipient) {
        System.out.println("Письмо [" + subject + "] отправлено получателю (" + recipient + ")");
    }
}
