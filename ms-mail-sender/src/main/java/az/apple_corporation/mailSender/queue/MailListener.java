package az.apple_corporation.mailSender.queue;

import lombok.extern.slf4j.Slf4j;
import az.apple_corporation.mailSender.model.MailDto;
import az.apple_corporation.mailSender.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MailListener {
    private final EmailService emailService;

    public MailListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${queue.mail-sender-q}")
    public void getMessage(MailDto mailDto) {
        emailService.sendSimpleMessage(mailDto);
        log.info("Message is " + mailDto);
    }
}