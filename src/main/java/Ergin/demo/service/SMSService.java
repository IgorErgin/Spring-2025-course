package Ergin.demo.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SMSService implements MessageService {

    @PostConstruct
    public void init() {
        log.info("SMSService bean created");
    }

    @PreDestroy
    public void destroy() {
        log.info("SMSService bean destroyed");
    }

    @Override
    public String getMessage() {
        return "SMS message";
    }
}
