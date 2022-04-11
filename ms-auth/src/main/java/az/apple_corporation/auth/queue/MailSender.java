package az.apple_corporation.auth.queue;

import az.apple_corporation.auth.mail.MailDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailSender {
    private final RabbitTemplate rabbitTemplate;
    private final String mailQ;

    public MailSender(RabbitTemplate rabbitTemplate, @Value("${queue.mail-sender-q}") String mailQ) {
        this.rabbitTemplate = rabbitTemplate;
        this.mailQ = mailQ;
    }

    public void sendEmail(MailDto mailDto) {
        rabbitTemplate.convertAndSend(mailQ, mailDto);
    }
}