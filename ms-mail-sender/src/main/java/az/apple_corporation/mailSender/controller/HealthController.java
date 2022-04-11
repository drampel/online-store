package az.apple_corporation.mailSender.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HealthController {
    @GetMapping("/readiness")
    public void readiness() {
        log.info("Readiness probe");
    }

    @GetMapping("/liveness")
    public void liveness() {
        log.info("Liveness probe");
    }
}