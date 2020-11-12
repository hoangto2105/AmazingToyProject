package vn.aptech.springboot.amazingtoy.service;

public interface EmailService {

    void sendSimpleMessage(
            String to, String subject, String text);
}
