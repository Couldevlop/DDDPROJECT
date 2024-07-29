package com.openlab.edition.infras.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    String mailSender;
    public void envoyerNotificationSansPieces(String to, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailSender);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

    }



}
