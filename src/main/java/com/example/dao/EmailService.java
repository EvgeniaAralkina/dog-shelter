package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void sendEmail(String new_message, String address) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(address);
        message.setFrom("unicorn1481@gmail.com");
        message.setSubject("Поздравляем! Тепрерь вы хозяин собаки!");
        message.setText(new_message);
        javaMailSender.send(message);
    }
}
