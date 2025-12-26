package com.example.Project.Example1.Auth_Management.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendStudentRegistrationEmail(String toEmail, String name, String password) {
        String subject = "Welcome to Our System";
        String body = "Hello " + name + ",\n\n" +
                "Your account has been created successfully.\n" +
                "Your login email: " + toEmail + "\n" +
//                "your phone number: " +  phoneNumber + "\n" +
                "Your temporary password: " + password + "\n\n" +
                "Please change your password after first login.\n\n" +
                "Regards,\nAdmin Team";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
}
