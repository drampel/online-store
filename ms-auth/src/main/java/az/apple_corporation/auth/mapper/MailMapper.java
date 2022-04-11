package az.apple_corporation.auth.mapper;

import az.apple_corporation.auth.mail.MailDto;

public class MailMapper {
    public static MailDto toMail(String to, String subject, String text) {
        return MailDto.builder()
                .to(to)
                .subject(subject)
                .text(text)
                .build();
    }
}