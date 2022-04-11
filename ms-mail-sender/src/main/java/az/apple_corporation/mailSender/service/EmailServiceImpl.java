package az.apple_corporation.mailSender.service;

import az.apple_corporation.mailSender.model.MailDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    private static final String SENDER_ADDRESS = "az.applecorporation@gmail.com";
    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendSimpleMessage(MailDto mailDto) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(SENDER_ADDRESS);
            message.setTo(mailDto.getTo());
            message.setSubject(mailDto.getSubject());
            message.setText(mailDto.getText());
            javaMailSender.send(message);
        } catch (MailException exception) {
            log.info(String.valueOf(exception));
        }
    }
}