package Ergin.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageProcessor {
    private final EmailService emailService;
    private final SMSService smsService;

    public MessageProcessor(EmailService emailService, SMSService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void processMessages() {
        log.info("Processing messages");
        log.info("Field injected: " + emailService.getMessage());
        log.info("Setter injected: " + smsService.getMessage());
    }
}
