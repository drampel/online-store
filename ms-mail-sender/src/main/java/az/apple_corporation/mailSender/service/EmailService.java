package az.apple_corporation.mailSender.service;

import az.apple_corporation.mailSender.model.MailDto;

public interface EmailService {
    void sendSimpleMessage(MailDto mailDto);
}