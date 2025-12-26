package com.example.Project.Example1.adminManagement.Service.ServiceImpl;

import com.example.Project.Example1.adminManagement.Service.OtpService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Random;

@Service
public class OtpServiceImpl implements OtpService {

    private final RedisTemplate<String, String> redisTemplate;
    private final JavaMailSender mailSender;

    public OtpServiceImpl(RedisTemplate<String, String> redisTemplate, JavaMailSender mailSender) {
        this.redisTemplate = redisTemplate;
        this.mailSender = mailSender;
    }
    @Value("${spring.otp.expiration.time}")
    private long otpExpirationTime;

    @Override
    public void generateAndSendOtp(String email) {
        String otp = String.valueOf(100000 + new Random().nextInt(900000));

        // Store OTP in Redis with 5 minutes expiration
        redisTemplate.opsForValue().set("OTP:" + email, otp, Duration.ofMinutes(otpExpirationTime));

        // Send OTP via email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your Password Reset OTP");
        message.setText("Your OTP is: " + otp + "\nIt will expire in 5 minutes.");
        mailSender.send(message);
    }

    @Override
    public boolean validateOtp(String email, String otp) {
        String storedOtp = redisTemplate.opsForValue().get("OTP:" + email);
        return otp.equals(storedOtp);
    }

    @Override
    public void clearOtp(String email) {
        redisTemplate.delete("OTP:" + email);
    }
}
