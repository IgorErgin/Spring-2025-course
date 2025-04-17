package Ergin.demo.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailService implements MessageService {

    @PostConstruct
    public void init() {
        log.info("EmailService bean created");
    }

    @PreDestroy
    public void destroy() {
        log.info("EmailService bean destroyed");
    }

    @Override
    public String getMessage() {
        return "Email message";
    }
}